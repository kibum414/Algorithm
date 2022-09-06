import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int T, N, answer;
    static int[][] record;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            N = s.length();
            record = new int[N][16];
            answer = 0;

            for (int day = 0; day < N; day++) {
                int key = 1 << (s.charAt(day) - 'A');

                for (int i = 0; i < 16; i++) {
                    if (day == 0) {
                        if ((i & key) > 0 && (i & 1) > 0) {
                            record[0][i] = 1;
                        }
                    } else {
                        if (record[day - 1][i] == 0) continue;

                        for (int j = 0; j < 16; j++) {
                            if ((i & j) > 0 && (key & j) > 0) {
                                record[day][j] += record[day - 1][i];
                                record[day][j] %= 1000000007;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 16; i++) {
                int temp = record[N - 1][i];

                if (temp > 0) {
                    answer += temp;
                    answer %= 1000000007;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);

    }

}