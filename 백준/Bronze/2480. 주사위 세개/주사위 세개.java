import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (a == b && a == c) System.out.println(10000 + a * 1000);
        else if (a == b || a == c) System.out.println(1000 + a * 100);
        else if (b == c) System.out.println(1000 + b * 100);
        else {
            if (a > b) {
                if (a > c) System.out.println(a * 100);
                else System.out.println(c * 100);
            } else {
                if (b > c) System.out.println(b * 100);
                else System.out.println(c * 100);
            }
        }

    }

}