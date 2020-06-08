package com.company.joelgamer.NetworkComponents.old;

import com.company.joelgamer.Core.Core;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client extends NetworkComponent {

    private final long id;
    protected Socket socket;

    public Client(Core core) {
        super(core);
        this.id = (long) (Math.random() * 10000000);
    }

    public void run() throws IOException {
        //new Thread(receive()).start();

        while (socket.isConnected()) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            send(message);
        }
    }

    public Client create() {
        int attempts = 0;
        socket = new Socket();

        while (!socket.isConnected()) {
            try {
                TimeUnit.SECONDS.sleep(1);
                socket = new Socket(getCore().getServerHost(), getCore().getServerPort());
            } catch (IOException | InterruptedException e) {
                System.out.print("Number of attempts: " + (++attempts) + "\r");
            }
        }

        if(attempts != 0) System.out.println();
        return this;
    }

    public void send(String message) throws IOException {
        if(!message.equals("") && socket.isConnected()) {
            sendMessage(socket, id + ": " + message);
        }
    }

    public String receive() throws IOException {
        String message = receiveIncomingMessage(socket);
        System.out.println(message);
        return message;
    }
}
