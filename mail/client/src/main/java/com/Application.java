package com;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 12.02.13
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String args[]) throws IOException {

        Socket socket = null;

        Response response;

        List<String> list = new ArrayList<String>();
        list.add("koya");
        list.add("petrov");
        list.add("12/12/12");
        list.add("123456");
        list.add("kolyapetrov");
        list.add("ololo");
        list.add("11/11/11");

        Request request = new Request(RequestCriteria.CREATE_ACCOUNT, list);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket("localhost", 4444);
            oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            oos.writeObject(request);
            oos.flush();
            System.out.println(socket.isClosed());

        }catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            response = (Response) ois.readObject();
            System.out.println(response);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
            if (ois != null) {
                ois.close();
            }
            socket.close();
        }

        while (true) {
            System.out.println("Doing something useful...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
