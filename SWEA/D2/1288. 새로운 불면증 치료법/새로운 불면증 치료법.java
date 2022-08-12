import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int T, N, value, cnt, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            value = 0;
            cnt = 0;
            n = 0;

            while (value != 1023) {
                n = N * ++cnt;

                String s = String.valueOf(n);

                for (int i = 0, len = s.length(); i < len; i++) {
                    value |= 1 << (s.charAt(i) - '0');
                }
            }

            sb.append("#").append(t).append(" ").append(n).append("\n");
        }

        System.out.println(sb);

    }

}