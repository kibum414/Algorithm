import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        for (int i = 0; i < 3; i++) {
            bw.write(cnt[i] + "\n");
        }

        bw.flush();

    }

    private static void divide(int row, int col, int n) {

        if (check(row, col, n)) cnt[map[row][col] + 1]++;
        else {
            int s = n / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + i * s, col + j * s, s);
                }
            }
        }

    }

    private static boolean check(int row, int col, int n) {

        int color = map[row][col];

        for (int r = row, rLen = row + n; r < rLen; r++) {
            for (int c = col, cLen = col + n; c < cLen; c++) {
                if (map[r][c] != color) return false;
            }
        }

        return true;

    }

}