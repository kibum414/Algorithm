import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        for (int i = 0, len = S.length(); i < len; i++) {
            int n = S.charAt(i) - 'a';

            if (arr[n] == -1) {
                arr[n] = i;
            }
        }

        for (int n : arr) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);

    }

}