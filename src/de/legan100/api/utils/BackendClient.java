package de.legan100.api.utils;

import de.legan100.api.API;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class BackendClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 10000;
    private static final long RECONNECT_DELAY = 5000L;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private Thread listenerThread;
    private Thread reconnectThread;

    private BukkitTask pingTask;

    private final AtomicBoolean connected = new AtomicBoolean(false);
    private final AtomicBoolean reconnecting = new AtomicBoolean(false);
    private final AtomicBoolean shuttingDown = new AtomicBoolean(false);

    public void connect() {

        if (shuttingDown.get()) return;

        try {
            openSocket();

            connected.set(true);
            System.out.println("[BackendClient] Connected");
            startListener();
            startPing();
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
                        if (line == null) break;
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
        if ("PONG".equalsIgnoreCase(msg)) return;
        if ("bc_globalrestart_allow".equalsIgnoreCase(msg)) {
            API.getInstance().getServer().shutdown();
            return;
        }
        System.out.println("[BACKEND] " + msg);
    }

    private void startPing() {
        if (pingTask != null) return;

        pingTask = Bukkit.getScheduler().runTaskTimerAsynchronously(API.getInstance(), () -> {
                    if (isConnected()) {
                        send("PING");
                    }}, 20L * 30, 20L * 30);
    }

    private void reconnect() {
        if (shuttingDown.get()) return;
        if (!reconnecting.compareAndSet(false, true)) return;

        reconnectThread = new Thread(() -> {
            try {
                while (!connected.get() && !shuttingDown.get()) {
                    try {
                        System.out.println("[BackendClient] Reconnecting...");
                        closeSocketQuietly();
                        openSocket();
                        connected.set(true);
                        System.out.println("[BackendClient] Reconnected");
                        startListener();
                        return;

                    } catch (Exception ignored) {}

                    try {
                        Thread.sleep(RECONNECT_DELAY);
                    } catch (InterruptedException ignored) {}
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
        if (!isConnected()) return;
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
    }
    private void closeSocketQuietly() {
        try {
            if (socket != null) {
                socket.shutdownInput();
                socket.shutdownOutput();
            }
        } catch (Exception ignored) {}

        try { if (in != null) in.close(); } catch (Exception ignored) {}
        try { if (out != null) out.close(); } catch (Exception ignored) {}
        try { if (socket != null) socket.close(); } catch (Exception ignored) {}

        in = null;
        out = null;
        socket = null;
    }
}