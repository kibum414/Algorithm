import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = N; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }

}