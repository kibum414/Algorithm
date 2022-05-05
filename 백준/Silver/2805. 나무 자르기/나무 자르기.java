import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max, min;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        trees = new int[N];
        max = 0;
        min = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                sum = trees[i] > mid ? sum + trees[i] - mid : sum;
            }

            if (sum < M) max = mid;
            else min = mid + 1;
        }

        System.out.println(max - 1);

    }

}