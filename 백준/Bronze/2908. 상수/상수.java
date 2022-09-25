import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = 0;
        B = 0;

        A += br.read() - '0';
        A += (br.read() - '0') * 10;
        A += (br.read() - '0') * 100;

        br.read();

        B += br.read() - '0';
        B += (br.read() - '0') * 10;
        B += (br.read() - '0') * 100;

        System.out.println(Math.max(A, B));

    }

}