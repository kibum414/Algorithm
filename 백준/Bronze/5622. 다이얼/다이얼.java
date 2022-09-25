import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;
    static int time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        time = 0;

        for (int i = 0, len = s.length(); i < len; i++) {
            int n = s.charAt(i);

            if (n < 68) time += 3;
            else if (n < 71) time += 4;
            else if (n < 74) time += 5;
            else if (n < 77) time += 6;
            else if (n < 80) time += 7;
            else if (n < 84) time += 8;
            else if (n < 87) time += 9;
            else time += 10;
        }

        System.out.println(time);

    }

}