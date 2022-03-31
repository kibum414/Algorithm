import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = st.nextToken();

            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            String s = st.nextToken();

            if (map.containsKey(s)) sb.append(map.get(s)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);

    }

}