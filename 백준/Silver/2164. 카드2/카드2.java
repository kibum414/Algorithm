import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        q = new int[2 * N];

        for (int i = 1; i <= N; i++) {
            q[i] = i;
        }

        int first = 1;
        int last = N;

        while (N-- > 1) {
            first++;

            q[last + 1] = q[first];

            first++;
            last++;
        }

        System.out.println(q[first]);

    }

}