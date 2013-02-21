package com;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 12.02.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class ServerApplication {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }

        while (listening)
            new ServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}
