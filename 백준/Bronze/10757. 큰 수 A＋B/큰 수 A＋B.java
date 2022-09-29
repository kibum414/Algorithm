import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String sA, sB;
    static int[] A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        sA = st.nextToken();
        sB = st.nextToken();

        int len = Math.max(sA.length(), sB.length());

        A = new int[len + 1];
        B = new int[len + 1];

        for (int i = sA.length() - 1, idx = 0; i >= 0; i--, idx++) {
            A[idx] = sA.charAt(i) - '0';
        }

        for (int i = sB.length() - 1, idx = 0; i >= 0; i--, idx++) {
            B[idx] = sB.charAt(i) - '0';
        }

        for (int i = 0; i < len; i++) {
            int n = A[i] + B[i];

            A[i] = n % 10;
            A[i + 1] += n / 10;
        }

        if (A[len] != 0) sb.append(A[len]);

        for (int i = len - 1; i >= 0; i--) {
            sb.append(A[i]);
        }

        System.out.println(sb);

    }

}