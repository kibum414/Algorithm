import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int T;
    static long N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Long.parseLong(br.readLine());

            long answer = -1;
            long left = 0;
            long right = (1L << 31) - 1;
            long middle = 0;

            while (left <= right) {
                middle = (left + right) / 2;
                long n = middle * (middle + 1) / 2;

                if (n == N) {
                    answer = middle;

                    break;
                } else if (n > N) right = middle - 1;
                else left = middle + 1;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.printf(String.valueOf(sb));

    }

}