import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] arr;
    static int[] indegree;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arr[S].add(E);

            indegree[E]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            bw.write(now + " ");

            for (int next : arr[now]) {
                if (--indegree[next] == 0) q.offer(next);
            }
        }

        bw.flush();

    }

}