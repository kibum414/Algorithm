import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int A, B;
    static String s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null) {
            A = s.charAt(0) - '0';
            B = s.charAt(2) - '0';

            sb.append(A + B).append("\n");
        }

        System.out.println(sb);

    }

}