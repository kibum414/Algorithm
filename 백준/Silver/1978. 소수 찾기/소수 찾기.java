import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, cnt;
    static boolean prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        cnt = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            prime = true;

            if (n == 1) continue;

            double len = Math.sqrt(n);

            for (int j = 2; j <= len; j++) {
                if (n % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) cnt++;
        }

        System.out.println(cnt);

    }

}