import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, start, end, answer;
    static int[] arr, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        start = 0;
        end = 0;
        answer = 0;
        cnt = new int[100001];

        while (end < N) {
            while (end < N && cnt[arr[end]] < K) {
                cnt[arr[end++]]++;
            }

            int len = end - start;

            if (answer < len) answer = len;

            cnt[arr[start++]]--;
        }

        System.out.println(answer);

    }

}