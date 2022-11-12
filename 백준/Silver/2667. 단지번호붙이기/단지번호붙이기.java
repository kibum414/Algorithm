import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';

                if (map[i][j] == 0) visit[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) bfs(i, j);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for (int n : list) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int i, int j) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visit[i][j] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if (!visit[nr][nc]) {
                    cnt++;
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        list.add(cnt);

    }

}