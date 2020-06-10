package com.company.joelgamer.NetworkComponents.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

    private final Socket socket;
    private final BufferedReader bufferedReader;

    protected ConnectionHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = bufferedReader.readLine();
                if(message == null) break;
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
