import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, H, min, cnt;
    static int[] top, bot;
    static int[] top_sum, bot_sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        top = new int[H + 1];
        bot = new int[H + 1];
        min = N;
        cnt = 0;

        for (int i = 0; i < N / 2; i++) {
            top[Integer.parseInt(br.readLine())]++;
            bot[Integer.parseInt(br.readLine())]++;
        }

        go();

        bw.write(min + " " + cnt);

        bw.flush();

    }

    private static void go() {

        top_sum = new int[H + 1];
        bot_sum = new int[H + 1];

        for (int i = 1; i <= H; i++) {
            top_sum[i] = top_sum[i - 1] + top[i];
            bot_sum[i] = bot_sum[i - 1] + bot[i];
        }

        for (int i = 1; i <= H; i++) {
            int n = 0;

            n += top_sum[H] - top_sum[H - i];
            n += bot_sum[H] - bot_sum[i - 1];

            if (min > n) {
                min = n;
                cnt = 1;
            } else if (min == n) cnt++;
        }

    }

}