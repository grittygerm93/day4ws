import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server {

    private int PORT;
    private String fileName; //need to pass to cookies


    public Server(String PORT, String fileName) {
        this.PORT = Integer.parseInt(PORT);
        this.fileName = fileName;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while(true) {
                CookieClientHandler handler = new CookieClientHandler(server.accept());
                Thread thread = new Thread(handler);
                thread.start();
           /* try (Socket socket = server.accept();
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
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}





