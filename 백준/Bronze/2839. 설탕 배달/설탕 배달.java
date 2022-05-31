import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = Integer.MAX_VALUE;
        int quotientFive = N / 5;

        for (int i = 0; i <= quotientFive; i++) {
            int n = N - i * 5;

            if (n % 3 == 0) cnt = Math.min(cnt, i + n / 3);
        }

        if (cnt == Integer.MAX_VALUE) cnt = -1;

        System.out.println(cnt);

    }

}