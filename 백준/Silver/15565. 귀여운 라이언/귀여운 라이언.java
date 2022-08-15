import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, K, answer;
    static int[] arr;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == 1) list.add(i);
        }

        if (list.size() < K) {
            System.out.println(-1);

            return;
        }

        answer = Integer.MAX_VALUE;

        for (int start = 0, len = list.size(); start < len; start++) {
            int end = start;
            int cnt = 0;

            while (end < len && cnt < K) {
                end++;
                cnt++;
            }

            if (cnt == K) {
                int left = list.get(start);
                int right = list.get(end - 1);

                answer = Math.min(answer, right - left + 1);
            }
        }

        System.out.println(answer);

    }

}