package com.company.joelgamer.NetworkComponents.old;

import com.company.joelgamer.Core.Core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends NetworkComponent {

    public Server(Core core) {
        super(core);
    }

    public void run() throws IOException {
        ServerSocket serverSocket = createServerSocket();

        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Connected!");
            Runnable connectionHandler = new ConnectionHandler(clientSocket);
            new Thread(connectionHandler).start();
        }
    }

    private ServerSocket createServerSocket() throws IOException {
        return new ServerSocket(getCore().getServerPort());
    }
}
