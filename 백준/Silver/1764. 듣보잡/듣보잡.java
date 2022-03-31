import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Set<String> set;
    static List<String> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        list = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            set.add(br.readLine());
        }

        for (int m = 0; m < M; m++) {
            String s = br.readLine();

            if (set.contains(s)) list.add(s);
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        list.forEach(s -> sb.append(s).append("\n"));

        System.out.println(sb);

    }

}