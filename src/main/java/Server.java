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
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                     DataInputStream input = new DataInputStream(socket.getInputStream())) {
                    Cookie cookie = new Cookie();
                    String clientMsg = input.readUTF();
                    if("get-cookie".equals(clientMsg))
                        output.writeUTF(cookie.retrieve());
                    if("close".equals(clientMsg)) {
                        output.writeUTF("close connection");
                        break;
                    }
                    else {
                        output.writeUTF("");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}





