import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int M, N, sum, min;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];

        getPrime();

        sum = 0;
        min = Integer.MAX_VALUE;

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sum += i;

                if (min == Integer.MAX_VALUE) min = i;
            }
        }

        if (sum == 0) sb.append(-1);
        else sb.append(sum).append("\n").append(min);

        System.out.println(sb);

    }

    private static void getPrime() {

        prime[0] = prime[1] = true;
        double len = Math.sqrt(N + 1);

        for (int i = 2; i <= len; i++) {
            if (prime[i]) continue;

            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

    }

}