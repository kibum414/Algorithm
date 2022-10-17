import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1);
        else {
            for (int i = 1; i <= 1023; i++) {
                long num = 0;
                int tmp = i;

                for (int idx = 9; idx >= 0; idx--) {
                    if (tmp % 2 == 1) num = 10 * num + idx;

                    tmp /= 2;
                }

                list.add(num);
            }

            Collections.sort(list);

            System.out.println(list.get(N));
        }

    }

}