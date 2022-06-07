import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());

            if (max < score) max = score;

            sum += score;
        }

        System.out.println((sum / max * 100) / N);

    }

}