import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static int[] arr;
    static long max, min, mid, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i]) max = arr[i];
        }

        max++;
        min = 0;
        mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            count = 0;

            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }

            if (count < N) max = mid;
            else min = mid + 1;
        }

        System.out.println(min - 1);

    }

}