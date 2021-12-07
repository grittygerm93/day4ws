import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        while (null != (line = br.readLine())) {
            cookieList.add(line);
        }

    }

    public String retrieve() {
        Random rand = new Random();
        return String.format("cookie-text %s",  cookieList.get(rand.nextInt(cookieList.size())));
    }

}

// to run use this in target folder
//java -cp fortunecookie-1.jar Main 12345 cookies.txt