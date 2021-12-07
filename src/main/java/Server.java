import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server {

    private int PORT;
    private String fileName;


    public Server(String PORT, String fileName) {
        this.PORT = Integer.parseInt(PORT);
        this.fileName = fileName;
    }

    public void start() {
        String line;
        while(true) {
            try (ServerSocket server = new ServerSocket(PORT)) {
                try (Socket socket = server.accept();
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
                    Cookie cookie = new Cookie();
                    output.writeUTF(cookie.retrieve());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}





