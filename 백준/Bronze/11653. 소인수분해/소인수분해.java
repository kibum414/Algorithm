import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        n = 2;

        while (n <= N) {
            if (N % n == 0) {
                sb.append(n).append("\n");

                N /= n;
            } else n++;
        }

        System.out.println(sb);

    }

}