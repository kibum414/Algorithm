import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        while ((cnt = countIce()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            melt();

            ans++;
        }

        System.out.println(ans);

    }

    private static int countIce() {

        visit = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visit[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;

    }

    private static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (map[nr][nc] > 0 && !visit[nr][nc]) {
                    q.offer(new int[] {nr, nc});
                    visit[nr][nc] = true;
                }
            }
        }

    }

    private static void melt() {

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] > 0) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                        if (!visit[nr][nc] && map[nr][nc] < 1) map[r][c]--;
                    }
                }
            }
        }

    }

}