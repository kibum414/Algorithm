import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0, len = N - i; j < len; j++) {
                sb.append(" ");
            }

            for (int j = 0, len = i * 2 - 1; j < len; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }

}