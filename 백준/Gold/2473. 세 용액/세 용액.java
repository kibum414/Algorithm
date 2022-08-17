import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long min;
    static long[] arr, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        answer = new long[3];
        min = Long.MAX_VALUE;

        for (int start = 0; start < N - 2; start++) {
            int mid = start + 1;
            int end = N - 1;

            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                long absSum = Math.abs(sum);

                if (min > absSum) {
                    answer[0] = arr[start];
                    answer[1] = arr[mid];
                    answer[2] = arr[end];

                    min = absSum;
                }

                if (sum == 0) break;
                else if (sum > 0) end--;
                else mid++;
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

    }

}