import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, max;
    static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        max = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, len = N - 1; j < len; j++) {
                swap(i, j, i, j + 1);

                check();

                swap(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, len = N - 1; j < len; j++) {
                swap(j, i, j + 1, i);

                check();

                swap(j, i, j + 1, i);
            }
        }

        System.out.println(max);

    }

    private static void swap(int x1, int y1, int x2, int y2) {

        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;

    }

    private static void check() {

        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0, len = N - 1; j < len; j++) {
                if (map[i][j] == map[i][j + 1]) cnt++;
                else cnt = 1;

                max = Math.max(max, cnt);
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0, len = N - 1; j < len; j++) {
                if (map[j][i] == map[j + 1][i]) cnt++;
                else cnt = 1;

                max = Math.max(max, cnt);
            }
        }

    }

}