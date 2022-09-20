import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C, hour, min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        min = B + C;

        if (min >= 60) {
            hour = A + min / 60;

            if (hour >= 24) System.out.println((hour - 24) + " " + (min % 60));
            else System.out.println(hour + " " + (min % 60));
        }
        else System.out.println(A + " " + (min % 60));

    }

}