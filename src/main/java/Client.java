import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Client {
//    private static final String SERVER_ADDRESS = "127.0.0.1";
//    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        String[] cmdInput = args[0].split(":");


        try (
                Socket socket = new Socket(cmdInput[0], Integer.parseInt(cmdInput[1]));
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            /*Scanner scanner = new Scanner(System.in);

            String msg = scanner.nextLine();

            output.writeUTF(msg); // sending message to the server*/
            String receivedMsg = input.readUTF(); // response message

            System.out.println("Received from server: " + receivedMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
