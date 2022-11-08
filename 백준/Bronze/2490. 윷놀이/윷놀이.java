import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            sum = 0;

            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum == 3) sb.append("A").append("\n");
            else if (sum == 2) sb.append("B").append("\n");
            else if (sum == 1) sb.append("C").append("\n");
            else if (sum == 0) sb.append("D").append("\n");
            else sb.append("E").append("\n");
        }

        System.out.println(sb);

    }

}