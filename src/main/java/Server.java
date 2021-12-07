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
        List<String> cookies = new ArrayList<>();
        while(true) {
            try (ServerSocket server = new ServerSocket(PORT)) {
                try (Socket socket = server.accept();
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                    InputStream in = getClass().getResourceAsStream("/cookies.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    while (null != (line = br.readLine())) {
                        cookies.add(line);
                    }
                    Random rand = new Random();
                    output.writeUTF(cookies.get(rand.nextInt(3)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}





