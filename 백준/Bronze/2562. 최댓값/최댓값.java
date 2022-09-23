import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int max, index;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        max = 0;

        for (int i = 1; i <= 9; i++) {
            int n = Integer.parseInt(br.readLine());

            if (max < n) {
                max = n;
                index = i;
            }
        }

        sb.append(max).append("\n").append(index);

        System.out.println(sb);

    }

}