package com.company.joelgamer;

import com.company.joelgamer.Core.Core;
import com.company.joelgamer.NetworkComponents.old.Client;
import com.company.joelgamer.NetworkComponents.old.Server;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Core core = new Core("src/Resources/core.properties");

        if(buildForServer(args)) {
            new Server(core).run();
        } else {
            new Client(core).create().run();
        }
    }

    private static boolean buildForServer(String[] args) {
        return args.length > 0 && args[0].equals("s");
    }
}
