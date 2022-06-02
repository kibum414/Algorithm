import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int C, N;
    static int[] scores;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            scores = new int[N];

            double avg = 0;
            double cnt = 0;

            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());

                scores[i] = value;
                avg += scores[i];
            }

            avg /= N;

            for (int i = 0; i < N; i++) {
                if (scores[i] > avg) cnt++;
            }

            sb.append(String.format("%.3f", cnt / N * 100)).append("%\n");
        }

        System.out.println(sb);

    }

}