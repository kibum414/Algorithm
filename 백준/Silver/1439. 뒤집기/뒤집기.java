import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer stOne = new StringTokenizer(s, "1");
        StringTokenizer stZero = new StringTokenizer(s, "0");

        int zeroCnt = stOne.countTokens();
        int oneCnt = stZero.countTokens();

        System.out.println(Math.min(zeroCnt, oneCnt));

    }

}