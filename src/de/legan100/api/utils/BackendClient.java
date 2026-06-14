package de.legan100.api.utils;

import org.bukkit.Bukkit;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class BackendClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 10000;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private final AtomicBoolean reconnecting = new AtomicBoolean(false);
    private final AtomicBoolean connected = new AtomicBoolean(false);

    public void connect() {
        try {

            socket = new Socket(HOST, PORT);

            socket.setKeepAlive(true);
            socket.setTcpNoDelay(true);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            connected.set(true);

            System.out.println("[BackendClient] Connected to backend");

            startListener();
            startPingTask();

        } catch (IOException e) {

            connected.set(false);

            System.err.println("[BackendClient] Connection failed");
            reconnect();
        }
    }

    private void startListener() {

        Thread listenerThread = new Thread(() -> {

            try {

                String line;

                while (connected.get()
                        && socket != null
                        && !socket.isClosed()
                        && (line = in.readLine()) != null) {

                    handleMessage(line);
                }

            } catch (Exception e) {

                if (connected.get()) {
                    System.err.println("[BackendClient] Connection lost");
                }

            } finally {

                connected.set(false);
                reconnect();
            }

        });

        listenerThread.setName("Backend-Listener");
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    private void handleMessage(String message) {

        if (message.equalsIgnoreCase("PONG")) {
            return;
        }

        System.out.println("[BACKEND] " + message);

    }

    private void startPingTask() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Bukkit.getPluginManager().getPlugin("API"), () -> {
                    if (!isConnected()) {
                        return;
                    }
                    send("PING");
                },20L * 30, 20L * 30);
    }

    private void reconnect() {

        if (!reconnecting.compareAndSet(false, true)) {
            return;
        }

        Thread reconnectThread = new Thread(() -> {
            while (!connected.get()) {
                try {
                    System.out.println("[BackendClient] Reconnecting...");
                    disconnectInternal();
                    socket = new Socket(HOST, PORT);
                    socket.setKeepAlive(true);
                    socket.setTcpNoDelay(true);
                    out = new PrintWriter(
                            socket.getOutputStream(),
                            true
                    );
                    in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );
                    connected.set(true);
                    System.out.println("[BackendClient] Reconnected");
                    startListener();
                    reconnecting.set(false);
                    return;

                } catch (Exception ignored) {}

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {}
            }
            reconnecting.set(false);
        });

        reconnectThread.setName("Backend-Reconnect");
        reconnectThread.setDaemon(true);
        reconnectThread.start();
    }

    public void send(String message) {
        try {
            if (!isConnected()) {
                return;
            }
            out.println(message);
        } catch (Exception e) {
            connected.set(false);
            reconnect();
        }
    }

    public boolean isConnected() {
        return connected.get() && socket != null && !socket.isClosed();
    }

    public void disconnect() {
        connected.set(false);
        disconnectInternal();
    }

    private void disconnectInternal() {
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
    }
}