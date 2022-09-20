import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);

    }

}