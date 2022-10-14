import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());

                map[i][j] = n;

                max = Math.max(max, n);
            }
        }

        int ans = 0;

        for (int n = 0; n < max; n++) {
            visit = new boolean[N + 2][N + 2];
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visit[i][j] && map[i][j] > n) {
                        cnt++;
                        dfs(i, j, n);
                    }
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }

    private static void dfs(int i, int j, int n) {

        visit[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if (map[nr][nc] == 0) continue;

            if (!visit[nr][nc] && map[nr][nc] > n) dfs(nr, nc, n);
        }

    }

}