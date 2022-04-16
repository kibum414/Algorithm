import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String str;
    static int N, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            ring += ring;

            if (ring.contains(str)) cnt++;
        }

        System.out.println(cnt);

    }

}