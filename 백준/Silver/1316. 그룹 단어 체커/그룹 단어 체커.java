import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        for (int i = 0; i < N; i++) {
            if (check(br.readLine())) cnt++;
        }

        System.out.println(cnt);

    }

    public static boolean check(String word) {

        boolean[] alphabet = new boolean[26];
        int prev = 0;

        for (int i = 0, len = word.length(); i < len; i++) {
            int now = word.charAt(i);
            int idx = now - 'a';

            if (prev != now) {
                if (!alphabet[idx]) {
                    alphabet[idx] = true;
                    prev = now;
                } else return false;
            }
        }

        return true;

    }

}