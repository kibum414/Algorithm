import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static Long[][] dp;
    static long result;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        result = 0;

        for (int i = 1; i < 10; i++) {
            result += recursive(N, i);
        }

        System.out.println(result % MOD);

    }

    private static long recursive(int n, int value) {

        if (n == 1) return 1;

        if (dp[n][value] == null) {
            if (value == 0) dp[n][value] = recursive(n - 1, 1);
            else if (value == 9) dp[n][value] = recursive(n - 1, 8);
            else dp[n][value] = recursive(n - 1, value - 1) + recursive(n - 1, value + 1);
        }

        return dp[n][value] % MOD;

    }

}