import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, R;
    static String S, P;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            P = "";

            R = Integer.parseInt(st.nextToken());
            S = st.nextToken();

            for (int i = 0, len = S.length(); i < len; i++) {
                char c = S.charAt(i);

                for (int j = 0; j < R; j++) {
                    P += c;
                }
            }

            sb.append(P).append("\n");
        }

        System.out.println(sb);

    }

}