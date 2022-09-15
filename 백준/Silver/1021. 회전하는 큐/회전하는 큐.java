import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static LinkedList<Integer> deque;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (num != deque.getFirst()) {
                if (deque.indexOf(num) <= deque.size() / 2) deque.offerLast(deque.pollFirst());
                else deque.offerFirst(deque.pollLast());

                cnt++;
            }

            deque.pollFirst();
        }

        System.out.println(cnt);

    }

}