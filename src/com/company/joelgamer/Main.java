package com.company.joelgamer;

import com.company.joelgamer.Core.Core;
import com.company.joelgamer.NetworkComponents.Client.Client;
import com.company.joelgamer.NetworkComponents.Server.Server;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Core core = new Core("src/Resources/core.properties");

        if(buildForServer(args)) {
            new Server(core).start();
        } else {
            new Client(core).start();
        }
    }

    private static boolean buildForServer(String[] args) {
        return args.length > 0 && args[0].equals("s");
    }
}
