import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        count = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        for (int i = 0; i < 3; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void divide(int row, int col, int n) {

        if (check(row, col, n)) {
            count[map[row][col] + 1]++;
        } else {
            int s = n / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + i * s, col + j * s, s);
                }
            }
        }

    }

    private static boolean check(int row, int col, int n) {

        int num = map[row][col];

        for (int r = row, rLen = row + n; r < rLen; r++) {
            for (int c = col, cLen = col + n; c < cLen; c++) {
                if (map[r][c] != num) return false;
            }
        }

        return true;

    }

}