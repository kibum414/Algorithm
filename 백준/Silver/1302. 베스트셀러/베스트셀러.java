import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int N;
    private static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int n = 0; n < N; n++) {
            String book = br.readLine();

            if (map.containsKey(book)) map.put(book, map.get(book) + 1);
            else map.put(book, 1);
        }

        int max = 0;
        String answer = "";

        for (String key : map.keySet()) {
            int cnt = map.get(key);

            if (max == cnt) {
                answer = answer.compareTo(key) > 0 ? key : answer;
            } else if (max < cnt) {
                max = cnt;
                answer = key;
            }
        }

        System.out.println(answer);

    }

}