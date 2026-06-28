package de.legan100.api.utils;

import de.legan100.api.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.*;

public class BackendClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 10000;
    private static final long RECONNECT_DELAY = 5000L;
    private static final int MAX_RECONNECT_ATTEMPTS = 3;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private Thread listenerThread;
    private Thread reconnectThread;

    private BukkitTask pingTask;

    private final AtomicBoolean connected = new AtomicBoolean(false);
    private final AtomicBoolean reconnecting = new AtomicBoolean(false);
    private final AtomicBoolean shuttingDown = new AtomicBoolean(false);

    private final AtomicInteger reconnectAttempts = new AtomicInteger(0);

    public void connect() {

        if (shuttingDown.get()) return;
        try {
            openSocket();
            connected.set(true);
            reconnectAttempts.set(0);
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("backend.admin")) {
                    player.sendMessage("[BackendClient] Connected");
                }
            }
            System.out.println("[BackendClient] Connected");
            startListener();
        } catch (Exception e) {
            connected.set(false);
            reconnect();
        }
    }

    private void openSocket() throws IOException {
        socket = new Socket(HOST, PORT);
        socket.setKeepAlive(true);
        socket.setTcpNoDelay(true);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void startListener() {
        listenerThread = new Thread(() -> {
            try {
                String line;
                while (!shuttingDown.get()) {
                    try {
                        line = in.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Exception e) {
                        break;
                    }
                    handle(line);
                }
            } finally {
                connected.set(false);
                if (!shuttingDown.get()) {
                    reconnect();
                }
            }
        });
        listenerThread.setName("Backend-Listener");
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    private void handle(String msg) {
        if ("bc_globalrestart_allow".equalsIgnoreCase(msg)) {
            API.getInstance().getServer().shutdown();
        } else if (msg.startsWith("gbc_")) {
            String zweiterString = "";
            for (int x = 0; x < msg.length(); x++) {
                if (msg.charAt(x) == '_') {
                    zweiterString = msg.substring(x + 1);
                    break;
                }
            }
            API.getInstance().getServer().broadcastMessage("§9-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            API.getInstance().getServer().broadcastMessage("");
            API.getInstance().getServer().broadcastMessage(zweiterString);
            API.getInstance().getServer().broadcastMessage("");
            API.getInstance().getServer().broadcastMessage("§9-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        } else if (msg.startsWith("bc_backendrestart")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("backend.admin")) {
                    player.sendMessage("Backendrestart");
                }
            }
        }

        System.out.println("[BACKEND] " + msg);
    }

    private void reconnect() {
        if (shuttingDown.get()) return;
        if (!reconnecting.compareAndSet(false, true)) {
            return;
        }

        reconnectThread = new Thread(() -> {
            try {
                while (!connected.get() && !shuttingDown.get()) {
                    int attempt = reconnectAttempts.incrementAndGet();
                    try {
                        System.out.println("[BackendClient] Reconnect attempt " + attempt + "/" + MAX_RECONNECT_ATTEMPTS);
                        closeSocketQuietly();
                        openSocket();
                        connected.set(true);
                        reconnectAttempts.set(0);
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (player.hasPermission("backend.admin")) {
                                player.sendMessage("Backend connected");
                            }
                        }
                        System.out.println("[BackendClient] Reconnected");
                        startListener();
                        send("statsport_" + API.getInstance().getServer().getPort());
                        return;
                    } catch (Exception ignored) {
                        if (attempt >= MAX_RECONNECT_ATTEMPTS) {
                            Bukkit.getLogger().severe("[BackendClient] Backend unreachable after " + MAX_RECONNECT_ATTEMPTS + " reconnect attempts. Shutting down server.");
                            Bukkit.getScheduler().runTask(API.getInstance(), Bukkit::shutdown);
                            return;
                        }
                    }
                    try {
                        Thread.sleep(RECONNECT_DELAY);
                    } catch (InterruptedException ignored) {
                        return;
                    }
                }
            } finally {
                reconnecting.set(false);
            }
        });

        reconnectThread.setName("Backend-Reconnect");
        reconnectThread.setDaemon(true);
        reconnectThread.start();
    }

    public void send(String msg) {

        if (!isConnected()) {
            return;
        }
        try {
            out.println(msg);
            if (out.checkError()) {
                throw new IOException("Write failed");
            }
        } catch (Exception e) {
            connected.set(false);
            if (!shuttingDown.get()) {
                reconnect();
            }
        }
    }

    public boolean isConnected() {
        return connected.get() && socket != null && !socket.isClosed();
    }

    public void disconnect() {
        shuttingDown.set(true);
        connected.set(false);
        System.out.println("DISCONNECT START");
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("backend.admin")) {
                player.sendMessage("DISCONNECT START");
            }
        }
        if (pingTask != null) {
            pingTask.cancel();
            pingTask = null;
        }
        closeSocketQuietly();
        if (listenerThread != null) {
            listenerThread.interrupt();
        }
        if (reconnectThread != null) {
            reconnectThread.interrupt();
        }
        System.out.println("DISCONNECT END");
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("backend.admin")) {
                player.sendMessage("DISCONNECT END");
            }
        }
    }

    private void closeSocketQuietly() {
        try {
            if (socket != null) {
                socket.shutdownInput();
                socket.shutdownOutput();
            }
        } catch (Exception ignored) {}

        try {
            if (in != null) {
                in.close();
            }
        } catch (Exception ignored) {}
        try {
            if (out != null) {
                out.close();
            }
        } catch (Exception ignored) {}

        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception ignored) {}

        in = null;
        out = null;
        socket = null;
    }
}