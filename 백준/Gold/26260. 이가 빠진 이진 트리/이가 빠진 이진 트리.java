import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        int sauce = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            tree[i] = node;

            if (node == -1) sauce = i;
        }

        tree[sauce] = Integer.parseInt(br.readLine());

        Arrays.sort(tree);

        dfs(0, N);

        System.out.println(sb);

    }

    private static void dfs(int start, int len) {

        if (len == 1) {
            sb.append(tree[start]).append(" ");

            return;
        }

        int half = len / 2;

        dfs(start, half);
        dfs(start + half + 1, half);

        sb.append(tree[start + half]).append(" ");

    }

}