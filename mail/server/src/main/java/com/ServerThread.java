package com;



import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 12.02.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class ServerThread extends Thread {

    private Socket socket = null;

    public ServerThread(Socket socket) throws IOException {
        super("com.ServerThread");
        this.socket = socket;
    }
//    }

    /*
    private com.Request getRequest() {

        ObjectInputStream ois = null;
        com.Request request = new com.Request();
        try {
            ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            request = (com.Request) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null)
                try {
                    ois.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return request;

    }
    */
//    private void sendResponse() {
//
    public void run() {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Request request;
        Response response;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            request = (Request) ois.readObject();
            System.out.println(request);
            response = (new RequestHandler(request)).handleRequest();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println(socket.isClosed());

        response = new Response();
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
