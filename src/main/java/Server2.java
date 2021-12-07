/*
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private static final int PORT = 12345;

    public Server2() {
        try (ServerSocket server = new ServerSocket(PORT)) {

            try (
                    Socket socket = server.accept(); // accepting a new client
                    //DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                String msg = input.readUTF(); // reading a message
                output.writeUTF("abcd"); // resend it to the client
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/
