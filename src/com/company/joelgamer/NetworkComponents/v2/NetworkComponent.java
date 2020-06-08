package com.company.joelgamer.NetworkComponents.v2;

import com.company.joelgamer.Core.Core;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkComponent {

    private final Core core;

    public NetworkComponent(Core core) {
        this.core = core;
    }

    protected Socket createClientSocket(Socket socket) throws IOException {
        while (!socket.isConnected()) {
            socket = new Socket(core.getServerHost(), core.getServerPort());
        }

        return socket;
    }

    protected ServerSocket createServerSocket() throws IOException {
        return new ServerSocket(core.getServerPort());
    }

    protected Core getCore() {
        return this.core;
    }
}
