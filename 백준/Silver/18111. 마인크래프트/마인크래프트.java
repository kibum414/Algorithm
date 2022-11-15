import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, B, min, max, minTime, height;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        min = 256;
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());

                map[i][j] = n;
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }

        minTime = Integer.MAX_VALUE;
        height = 0;

        for (int h = min; h <= max; h++) {
            int block = B;
            int time = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int n = map[i][j];

                    if (n > h) {
                        block += n - h;
                        time += (n - h) * 2;
                    } else if (n < h) {
                        block -= h - n;
                        time += h - n;
                    }
                }
            }

            if (block >= 0 && minTime >= time) {
                minTime = time;
                height = h;
            }
        }

        System.out.println(minTime + " " + height);

    }

}