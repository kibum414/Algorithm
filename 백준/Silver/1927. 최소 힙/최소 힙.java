import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else pq.offer(n);
        }

        System.out.println(sb);

    }

}