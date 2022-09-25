import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        count();

        System.out.println(cnt);

    }

    private static void count() {

        if (N < 100) cnt = N;
        else {
            cnt = 99;

            for (int i = 100; i <= N; i++) {
                int hundred = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hundred - ten) == (ten - one)) cnt++;
            }
        }

    }

}