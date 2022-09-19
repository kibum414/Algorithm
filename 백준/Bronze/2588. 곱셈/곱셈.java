import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());

        sb.append(A * (B % 10)).append("\n").append(A * (B / 10 % 10)).append("\n").append(A * (B / 100)).append("\n").append(A * B);

        System.out.println(sb);

    }

}