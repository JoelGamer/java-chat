package com.company.joelgamer.NetworkComponents.v2;

import com.company.joelgamer.Core.Core;

import java.io.IOException;
import java.net.Socket;

public class Client extends NetworkComponent {

    private Socket socket = new Socket();

    public Client(Core core) {
        super(core);
    }

    public Client create() throws IOException {
        this.socket = createClientSocket(this.socket);
        return this;
    }

    public void run() {

    }
}
