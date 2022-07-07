import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N, cnt;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visit = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int i) {
        visit[i] = true;

        if (!visit[arr[i]]) dfs(arr[i]);
    }

}