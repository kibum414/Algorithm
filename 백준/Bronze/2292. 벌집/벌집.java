import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt, range;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 1;
        range = 2;

        if (N > 1) {
            while (range <= N) {
                range += 6 * cnt;
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}