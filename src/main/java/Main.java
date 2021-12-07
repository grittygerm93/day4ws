public class Main {
    public static void main(String[] args) {
//        String PORT = args[0];
//        String fileName = args[1];
        Server server = new Server("12345", "cookies.txt");
        server.start();
//        System.out.println(PORT);
//        System.out.println(fileName);

    }


}
