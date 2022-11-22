import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 1; i <= 10; i++) {
            sb.append(N).append(" x ").append(i).append(" = ").append(N * i).append("\n");
        }

        System.out.println(sb);

        bufferedReader.close();

    }

}
