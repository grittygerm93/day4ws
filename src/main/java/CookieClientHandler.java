import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable {
    private Socket socket;
    private String fileName;

    public CookieClientHandler(Socket socket, String fileName) {
        this.socket = socket;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {
//            while (input.available() > 0) {
            while(true) {
                Cookie cookie = new Cookie(fileName);
                String clientMsg = input.readUTF();
                if ("get-cookie".equals(clientMsg))
                    output.writeUTF(cookie.retrieve());
                if ("close".equals(clientMsg)) {
                    output.writeUTF("close connection");
                    break;
                } else {
                    output.writeUTF("");
                }
            }
        }catch (EOFException e) {
        }
        catch (IOException e) {
                e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("socket close catch");
            e.printStackTrace();
        }
    }
}
//solution throws EOFException which is expected and can be handled without crashing the prog
//more details refer to https://stackoverflow.com/questions/18451232/eofexception-how-to-handle
//suggests to use in.available();

//put the while loop under the try-with block because if Dataoutputstream or DIS is closed socket is also closed
//details refere here https://stackoverflow.com/questions/15239398/java-net-socketexception-socket-is-closed