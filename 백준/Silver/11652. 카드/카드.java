import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static long[] cards;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(cards);

        int cnt = 1, max = 1, maxIdx = 0;

        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i - 1]) cnt++;
            else cnt = 1;

            if (cnt > max) {
                max = cnt;
                maxIdx = i;
            }
        }

        System.out.println(cards[maxIdx]);

    }

}