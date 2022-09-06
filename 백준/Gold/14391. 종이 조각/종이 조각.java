import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans, sum, cur;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int s = 0, len = 1 << (N * M); s < len; s++) {
            sum = 0;

            // 가로 : 0
            for (int i = 0; i < N; i++) {
                cur = 0;

                for (int j = 0; j < M; j++) {
                    int k = i * M + j;

                    // s의 k번째 비트가 0 : 가로
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + map[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            // 세로 : 1
            for (int j = 0; j < M; j++) {
                cur = 0;

                for (int i = 0; i < N; i++) {
                    int k = i * M + j;

                    // s의 k번째 비트가 1 : 세로
                    if ((s & 1 << k) > 0) {
                        cur = cur * 10 + map[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);

    }

}