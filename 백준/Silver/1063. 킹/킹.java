import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String king, stone, cmd;
    static int N, kingX, kingY, stoneX, stoneY;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        king = st.nextToken();
        kingX = king.charAt(0) - 'A';
        kingY = king.charAt(1) - '1';
        stone = st.nextToken();
        stoneX = stone.charAt(0) - 'A';
        stoneY = stone.charAt(1) - '1';
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            cmd = br.readLine();
            int idx = 0;

            switch (cmd) {
                case "R": idx = 0; break;
                case "L": idx = 1; break;
                case "B": idx = 2; break;
                case "T": idx = 3; break;
                case "RT": idx = 4; break;
                case "LT": idx = 5; break;
                case "RB": idx = 6; break;
                case "LB": idx = 7; break;
            }

            int nextX = kingX + dx[idx];
            int nextY = kingY + dy[idx];

            if (nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8) {
                if (nextX == stoneX && nextY == stoneY) {
                    int tempX = stoneX + dx[idx];
                    int tempY = stoneY + dy[idx];

                    if (tempX >= 0 && tempX < 8 && tempY >= 0 && tempY < 8) {
                        stoneX = tempX;
                        stoneY = tempY;
                    } else continue;
                }

                kingX = nextX;
                kingY = nextY;
            }
        }

        sb.append((char) (kingX + 'A')).append(kingY + 1).append("\n");
        sb.append((char)(stoneX + 'A')).append(stoneY + 1);

        System.out.println(sb);
    }

}