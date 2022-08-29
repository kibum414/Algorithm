import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, start, end;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[201];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                start = (Integer.parseInt(st.nextToken()) + 1) / 2;
                end = (Integer.parseInt(st.nextToken()) + 1) / 2;

                if (start <= end) {
                    for (int j = start; j <= end; j++) {
                        map[j]++;
                    }
                } else {
                    for (int j = end; j <= start; j++) {
                        map[j]++;
                    }
                }
            }

            Arrays.sort(map);

            sb.append("#").append(t).append(" ").append(map[200]).append("\n");
        }

        System.out.println(sb);

    }

}