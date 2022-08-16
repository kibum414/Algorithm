import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int G, start, end;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        G = Integer.parseInt(br.readLine());

        start = 1;
        end = 2;
        flag = false;

        while (start < end) {
            int diff = end * end - start * start;

            if (diff == G) {
                flag = true;
                sb.append(end).append("\n");
            }

            if (diff < G) end++;
            else start++;
        }

        if (!flag) sb.append(-1);

        System.out.println(sb);

    }

}