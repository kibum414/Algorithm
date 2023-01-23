import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stMinus = new StringTokenizer(br.readLine(), "-");
        StringTokenizer stPlus;
        int total = 0;
        boolean isFirst = false;

        while (stMinus.hasMoreTokens()) {
            int sum = 0;

            stPlus = new StringTokenizer(stMinus.nextToken(), "+");

            while (stPlus.hasMoreTokens()) {
                sum += Integer.parseInt(stPlus.nextToken());
            }

            if (!isFirst) {
                total = sum;
                isFirst = true;
            } else total -= sum;
        }

        System.out.println(total);

    }

}