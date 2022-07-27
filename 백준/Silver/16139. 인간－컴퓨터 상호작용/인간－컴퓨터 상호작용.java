import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static String S;
    static int q;
    static int[][] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        S = br.readLine();
        sum = new int[S.length()][26];

        sum[0][S.charAt(0) - 'a']++;

        for (int i = 1; i < S.length(); i++) {
            int temp = S.charAt(i) - 'a';

            System.arraycopy(sum[i - 1], 0, sum[i], 0, 26);

            sum[i][temp]++;
        }

        q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char find = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 0) sb.append(sum[end][find - 'a']).append("\n");
            else sb.append(sum[end][find - 'a'] - sum[start - 1][find - 'a']).append("\n");
        }

        System.out.println(sb);

    }

}