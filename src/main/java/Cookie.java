import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    List<String> cookieList;

    public Cookie() throws IOException {
        cookieList = new ArrayList<>();
        String line;
        InputStream in = getClass().getResourceAsStream("/cookies.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        FileReader in = new FileReader("/cookies.txt");
//        BufferedReader br = new BufferedReader(in);
        while (null != (line = br.readLine())) {
            cookieList.add(line);
        }

    }

    public String retrieve() {
        Random rand = new Random();
        return String.format("cookie-text %s",  cookieList.get(rand.nextInt(cookieList.size())));
    }

}

//try (Reader reader = new FileReader(fileName1)) {
//        BufferedReader br = new BufferedReader(reader);
//        while (null != (line = br.readLine())) {
//        System.out.println("LINE: " + line);
//        list1.add(line);
//        }
//        }

// to run use this in target folder
//java -cp fortunecookie-1.jar Main 12345 cookies.txt