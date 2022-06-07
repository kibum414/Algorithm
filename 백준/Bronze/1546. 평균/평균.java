import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max;
    static int[] scores;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        scores = new int[N];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());

            scores[i] = score;

            if (max < score) max = score;
        }

        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += scores[i] / (double) max * 100;
        }

        System.out.println(sum / N);

    }

}