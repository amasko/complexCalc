
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

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
        Request request = new Request("hzop", 2);
        Response response;

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
    }
}
