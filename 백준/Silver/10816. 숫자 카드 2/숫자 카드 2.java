import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, Integer> map;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = st.nextToken();

            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            String s = st.nextToken();

            list.add(map.getOrDefault(s, 0));
        }

        list.forEach(s -> sb.append(s).append(" "));

        System.out.println(sb);

    }

}