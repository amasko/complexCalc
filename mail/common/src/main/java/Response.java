import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 13.02.13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class Response implements Serializable {

    private String message;
    private int data;

    public Response() {
        this.message = "second";
        this.data = 15;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMessage() {

        return message;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return message + " " + data + " ;";
    }

}
