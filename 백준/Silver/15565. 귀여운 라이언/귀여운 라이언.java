import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, end, cnt, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        end = 0;
        answer = N + 1;
        cnt = 0;

        for (int start = 1; start <= N; start++) {
            if (arr[start - 1] == 1) cnt--;

            while (end + 1 <= N && cnt < K) {
                if (arr[++end] == 1) cnt++;
            }

            if (cnt == K) answer = Math.min(answer, end - start + 1);
        }

        if (answer == N + 1) answer = -1;

        System.out.println(answer);

    }

}