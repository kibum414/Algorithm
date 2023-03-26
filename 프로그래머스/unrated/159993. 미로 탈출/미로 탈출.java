import java.util.*;

class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visit;
    static int lenX, lenY;

    public int solution(String[] maps) {

        int answer = 0;
        lenX = maps.length;
        lenY = maps[0].length();
        map = new char[lenX][lenY];
        int startX = 0, startY = 0, leverX = 0, leverY = 0, endX = 0, endY = 0;

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c;

                if (c == 'S') {
                    startX = i;
                    startY = j;
                }

                if (c == 'L') {
                    leverX = i;
                    leverY = j;
                }

                if (c == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        answer = bfs(startX, startY, leverX, leverY);

        if (answer > -1) {
            int cnt = bfs(leverX, leverY, endX, endY);

            if (cnt == -1) answer = -1;
            else answer += cnt;
        }

        return answer;

    }

    private static int bfs(int startX, int startY, int endX, int endY) {

        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[lenX][lenY];

        q.add(new int[] {startX, startY, 0});
        visit[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int cnt = now[2];

            if (r == endX && c == endY) return cnt;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= lenX || nc < 0 || nc >= lenY) continue;

                if (map[nr][nc] != 'X' && !visit[nr][nc]) {
                    q.add(new int[] {nr, nc, cnt + 1});
                    visit[nr][nc] = true;
                }
            }
        }

        return -1;

    }

}