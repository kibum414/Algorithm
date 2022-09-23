import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max, min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        max = -1000000;
        min = 1000000;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (max < n) max = n;
            if (min > n) min = n;
        }

        System.out.println(min + " " + max);

    }

}