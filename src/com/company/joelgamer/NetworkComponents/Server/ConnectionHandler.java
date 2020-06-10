package com.company.joelgamer.NetworkComponents.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionHandler implements Runnable {

    private final Socket socket;
    private final ArrayList<ConnectionHandler> connectionHandlers;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;

    protected ConnectionHandler(Socket socket, ArrayList<ConnectionHandler> connectionHandlers) throws IOException {
        this.socket = socket;
        this.connectionHandlers = connectionHandlers;
        bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        printWriter = new PrintWriter(this.socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = bufferedReader.readLine();
                if (message == null) break;
                System.out.println("[CLIENT] " + message);
                callback(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void callback(String message) {
        connectionHandlers.forEach(connectionHandler -> connectionHandler.printWriter.println(message));
    }

    private void closeConnection() {
        try {
            bufferedReader.close();
            printWriter.close();
            socket.close();
            System.out.println("[CLIENT] Client connection closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
