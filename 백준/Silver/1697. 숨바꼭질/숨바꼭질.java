import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }

    private static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int n = q.poll();

            if (n == K) return visit[n];

            if (n - 1 >= 0 && visit[n - 1] == 0) {
                visit[n - 1] = visit[n] + 1;
                q.offer(n - 1);
            }

            if (n + 1 <= 100000 && visit[n + 1] == 0) {
                visit[n + 1] = visit[n] + 1;
                q.offer(n + 1);
            }

            if (n * 2 <= 100000 && visit[n * 2] == 0) {
                visit[n * 2] = visit[n] + 1;
                q.offer(n * 2);
            }
        }

        return -1;

    }

}