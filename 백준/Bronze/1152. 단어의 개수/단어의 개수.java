import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int str, pre_str, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = 0;
        pre_str = 32;

        while (true) {
            str = br.read();

            if (str == 32) {
                if (pre_str != 32) cnt++;
            } else if (str == 10) {
                if (pre_str != 32) cnt++;

                break;
            }

            pre_str = str;
        }

        System.out.println(cnt);

    }

}