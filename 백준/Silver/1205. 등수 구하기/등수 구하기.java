import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N, S, P;
    static Integer[] scores;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();
        P = scanner.nextInt();
        scores = new Integer[N];

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
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