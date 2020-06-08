package com.company.joelgamer.NetworkComponents.old;

import com.company.joelgamer.Core.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkComponent {

    private final Core core;

    public NetworkComponent() {
        this.core = null;
    }

    public NetworkComponent(Core core) {
        this.core = core;
    }

    protected void sendMessage(Socket socket, String message) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(message);
        printWriter.flush();
    }

    protected String receiveIncomingMessage(Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return bufferedReader.readLine();
    }

    protected Core getCore() {
        return core;
    }
}
