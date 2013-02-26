package com;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerApplication {

    private final static Logger LOG = Logger.getLogger(ServerApplication.class);
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;
        LOG.info("Creating serverSocket");
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            LOG.error("Could not listen on port: 4444.");
            System.exit(-1);
        }
        LOG.info("Listening for connections");
        while (listening)
            new ServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}
