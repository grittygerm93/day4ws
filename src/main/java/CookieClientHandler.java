import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable {
    private Socket socket;

    public CookieClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try (DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                 DataInputStream input = new DataInputStream(socket.getInputStream())) {
                Cookie cookie = new Cookie();
                String clientMsg = input.readUTF();
                if ("get-cookie".equals(clientMsg))
                    output.writeUTF(cookie.retrieve());
                if ("close".equals(clientMsg)) {
                    output.writeUTF("close connection");
                    socket.close();
                    break;
                } else {
                    output.writeUTF("");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
