package com.company.joelgamer.Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Core {

    private String serverHost;
    private int serverPort;

    public Core(String corePropertiesFile) throws IOException {
        loadCoreProperties(corePropertiesFile);
    }

    private void loadCoreProperties(String corePropertiesFile) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(corePropertiesFile);
        properties.load(input);

        setServerHost(properties);
        setServerPort(properties);
    }

    public String getServerHost() {
        return serverHost;
    }

    private void setServerHost(Properties properties) {
        this.serverHost = properties.getProperty("serverHost");
    }

    public int getServerPort() {
        return serverPort;
    }

    private void setServerPort(Properties properties) {
        this.serverPort = Integer.parseInt(properties.getProperty("serverPort"));
    }
}
