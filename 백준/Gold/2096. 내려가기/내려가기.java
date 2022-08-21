import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max, min;
    static int[] arr, dpMax, dpMin, temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[3];
        dpMax = new int[3];
        dpMin = new int[3];
        temp = new int[3];
        max = 0;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if (i == 0) {
                dpMax[0] = dpMin[0] = arr[0];
                dpMax[1] = dpMin[1] = arr[1];
                dpMax[2] = dpMin[2] = arr[2];

                continue;
            }

            temp[0] = arr[0] + Math.max(dpMax[0], dpMax[1]);
            temp[1] = arr[1] + Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
            temp[2] = arr[2] + Math.max(dpMax[1], dpMax[2]);

            dpMax[0] = temp[0];
            dpMax[1] = temp[1];
            dpMax[2] = temp[2];

            temp[0] = arr[0] + Math.min(dpMin[0], dpMin[1]);
            temp[1] = arr[1] + Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));
            temp[2] = arr[2] + Math.min(dpMin[1], dpMin[2]);

            dpMin[0] = temp[0];
            dpMin[1] = temp[1];
            dpMin[2] = temp[2];
        }

        for (int num : dpMax) {
            max = Math.max(max, num);
        }

        for (int num : dpMin) {
            min = Math.min(min, num);
        }

        System.out.println(max + " " + min);

    }

}