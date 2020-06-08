package com.company.joelgamer.NetworkComponents.old;

import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler extends NetworkComponent implements Runnable {

    private final Socket socket;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            String message = getMessageThroughSocket();
            System.out.println(message);
            //sendMessageThroughSocket(message);
        }
    }

    public void sendMessageThroughSocket(String message) {
        try {
            sendMessage(socket, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessageThroughSocket() {
        String message = "";

        try {
            message = receiveIncomingMessage(socket);
            if(!message.equals("")) System.out.println(message);
            else socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }
}
