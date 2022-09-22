import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt, cur, tens, units;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cur = N;
        cnt = 0;

        do {
            tens = cur / 10;
            units = cur % 10;

            cur = units * 10 + (tens + units) % 10;

            cnt++;
        } while (N != cur);

        System.out.println(cnt);

    }

}