import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, sum;
    static String num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sum = 0;
        num = br.readLine();

        for (int i = 0; i < N; i++) {
            sum += num.charAt(i) - '0';
        }

        System.out.println(sum);

    }

}