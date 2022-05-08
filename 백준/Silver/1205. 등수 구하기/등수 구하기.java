import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, S, P;
    static Integer[] scores;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        scores = new Integer[N];

        if (N != 0) st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, Collections.reverseOrder());

        if (N == P && S <= scores[N - 1]) System.out.println(-1);
        else {
            int rank = 1;

            for (int s : scores) {
                if (S < s) rank++;
                else break;
            }

            System.out.println(rank);
        }

    }

}