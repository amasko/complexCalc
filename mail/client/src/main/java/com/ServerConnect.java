package com;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 12.02.13
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
public class ServerConnect {

    private static Socket socket = null;

    /**
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static synchronized Response connect(Request request) throws IOException{

        Response response = null;

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket("localhost", 4444);
            oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            oos.writeObject(request);
            oos.flush();

        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ois = new ObjectInputStream(new BufferedInputStream(socket != null ? socket.getInputStream() : null));
            response = (Response) ois.readObject();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null) {
                oos.close();
            }
            if (ois != null) {
                ois.close();
            }
            if (socket != null) {
                socket.close();
            }
        }

        return response;
    }
}
