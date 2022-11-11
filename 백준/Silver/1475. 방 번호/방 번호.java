import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[10];
        max = -1;

        while (N > 0) {
            int n = N % 10;

            if (n == 6 || n == 9) {
                if (arr[n] == max && max > arr[15 - n]) arr[15 - n]++;
                else arr[n]++;
            } else {
                arr[n]++;
            }

            if (max < arr[n]) max = arr[n];

            N /= 10;
        }

        System.out.println(max);

    }

}