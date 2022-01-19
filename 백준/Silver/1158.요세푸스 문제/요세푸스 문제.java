import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<Integer>();

		for (int i = 1; i <= N; i++) q.offer(i);

		int cnt = 1;
		sb.append("<");
		while (!q.isEmpty()) {
			if (cnt++ % K == 0) sb.append(q.poll() + ", ");
			else q.offer(q.poll());
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);
	}

}