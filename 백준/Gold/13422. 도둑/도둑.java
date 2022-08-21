import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M, K, sum, start, end, cnt;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N];
            sum = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());

                if (i < M) sum += map[i];
            }

            start = 0;
            end = M;

            if (N == M) {
                if (sum < K) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else {
                cnt = 0;

                while (start < N) {
                    if (sum < K) cnt++;

                    sum -= map[start++];
                    sum += map[end++ % N];
                }

                sb.append(cnt).append("\n");
            }
        }

        System.out.println(sb);

    }

}