import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, r, c, cnt;
    static boolean[] visit;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        cnt = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map[r][c] = map[c][r] = true;
        }
        
        bfs(1);

        System.out.println(cnt);

    }

    private static void bfs(int n) {

        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visit[n] = true;

        while (!q.isEmpty()) {
            int m = q.poll();

            for (int i = 1; i <= N; i++) {
                if (map[i][m] && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }

    }

}