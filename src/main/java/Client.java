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
        boolean exitLoop = false;
        while (true) {
            try (
                    Socket socket = new Socket(cmdInput[0], Integer.parseInt(cmdInput[1]));
//                    Socket socket = new Socket(SERVER_ADDRESS, 12345);
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {


                //initial connection
                //problematic line why???
                /*output.writeUTF("get-cookie"); //sending msg to server
                fromServer(input);*/


                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                switch (msg) {
                    case "get-cookie":
                        output.writeUTF(msg);
                        //System.out.println(input.readUTF());
                        fromServer(input);
                        break;
                    case "close":
                        output.writeUTF(msg);
                        System.out.println("Received from server: " + input.readUTF());
                        exitLoop = true;
                        break;
                    default:
                        System.out.println("no such command");
                        output.writeUTF("");
                        input.readUTF();
                }



            } catch (IOException e) {
                //System.out.println("sdfs");
                e.printStackTrace();
            }
        if(exitLoop)
            break;
        }
    }

    public static void fromServer(DataInputStream input){
        try {
            String receivedMsg = input.readUTF();
            System.out.println("Received from server: " + receivedMsg.split("\\s+")[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// to run use this in target folder
//java -cp fortunecookie-1.jar Client localhost:12345
