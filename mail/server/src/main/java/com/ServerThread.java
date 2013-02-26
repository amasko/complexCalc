package com;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket = null;

    public ServerThread(Socket socket) throws IOException {
        super("com.ServerThread");
        this.socket = socket;
    }

    public void run() {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Request request = null;
        Response response = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            request = (Request) ois.readObject();
            System.out.println(request);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println(socket.isClosed());
        response = (new RequestHandler(request)).handleRequest();
        //response = new Response();
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            oos.writeObject(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (oos != null && ois != null) {
                    oos.close();
                    ois.close();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
