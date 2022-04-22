import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String s = st.nextToken();

                map.put(s, map.getOrDefault(s, 0) + 1);

            }

            int answer = 1;

            for (int v : map.values()) {
                answer *= v + 1;
            }

            sb.append(answer - 1).append("\n");

        }

        System.out.println(sb);

    }

}