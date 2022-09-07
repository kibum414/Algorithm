import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static int[][] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u][v] = adj[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int i) {

        visit[i] = true;

        for (int j = 1; j <= N; j++) {
            if (!visit[j] && adj[i][j] == 1) dfs(j);
        }

    }

}