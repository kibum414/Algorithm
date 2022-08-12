import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, M;
    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int toBinary = (1 << N) - 1;

            if ((M & toBinary) == toBinary) answer = "ON";
            else answer = "OFF";

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);

    }

}