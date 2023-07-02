import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String document, word;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        document = br.readLine();
        word = br.readLine();
        int dLen = document.length();
        int wLen = word.length();
        int cnt = 0;

        for (int i = 0; i <= dLen - wLen; i++) {
            boolean flag = true;

            for (int j = 0; j < wLen; j++) {
                if (document.charAt(i + j) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
                i += wLen - 1;
            }
        }

        System.out.println(cnt);

    }

}