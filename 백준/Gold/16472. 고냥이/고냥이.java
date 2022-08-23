import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, start, end, cnt, len, max;
    static String str;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        arr = new int[26];
        start = 0;
        end = 0;
        cnt = 0;
        max = 0;
        len = str.length();

        while (end < len) {
            int num = str.charAt(end) - 'a';
            arr[num]++;

            if (arr[num] == 1) cnt++;

            while (cnt > N) {
                int num2 = str.charAt(start++) - 'a';
                arr[num2]--;

                if (arr[num2] == 0) cnt--;
            }

            end++;

            max = Math.max(max, end - start);
        }

        System.out.println(max);

    }

}