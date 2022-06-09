import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long n1 = 0;
        long n2 = 1;
        long sum = 1;

        for (int i = 1; i < N; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        System.out.println(sum);

    }

}