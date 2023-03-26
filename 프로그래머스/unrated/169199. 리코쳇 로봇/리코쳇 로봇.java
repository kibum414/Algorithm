import java.util.*;

class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visit;
    static int lenX, lenY;

    public int solution(String[] board) {

        int answer = 0;
        lenX = board.length;
        lenY = board[0].length();
        map = new char[lenX][lenY];
        visit = new boolean[lenX][lenY];
        int startX = 0, startY = 0, endX = 0, endY = 0;

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                char c = board[i].charAt(j);
                map[i][j] = c;

                if (c == 'R') {
                    startX = i;
                    startY = j;
                }

                if (c == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }

        answer = bfs(startX, startY, endX, endY);

        return answer;

    }

    private static int bfs(int startX, int startY, int endX, int endY) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX, startY, 0});
        visit[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int cnt = now[2];

            if (r == endX && c == endY) return cnt;

            for (int i = 0; i < 4; i++) {
                int tr = r;
                int tc = c;
                int ir = dr[i];
                int ic = dc[i];

                while (tr + ir >= 0 && tr + ir < lenX && tc + ic >= 0 && tc + ic < lenY && map[tr + ir][tc + ic] != 'D') {
                    tr += ir;
                    tc += ic;
                }

                if (!visit[tr][tc]) {
                    q.add(new int[] {tr, tc, cnt + 1});
                    visit[tr][tc] = true;
                }
            }
        }

        return -1;

    }

}