public class Main {
    public static void main(String[] args) {
        String PORT = args[0];
        String fileName = args[1];
        Server server = new Server(PORT, fileName);
//        Server server = new Server("12345", "cookies.txt");
        server.start();

        // to run use this in target folder
        //java -cp fortunecookie-1.jar Main 12345 cookies.txt
    }


}
