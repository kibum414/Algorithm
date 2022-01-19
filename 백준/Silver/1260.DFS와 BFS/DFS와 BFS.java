import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static boolean[][] adjMatrix;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N][N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}

        visited[V - 1] = true;
		dfs(V - 1, visited);
		System.out.println(sb);
		bfs(V - 1);
		System.out.println(sb);
	}

	private static void bfs(int current) {
		sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		queue.offer(current);
		visited[current] = true;

		while (!queue.isEmpty()) {
			current = queue.poll();
			sb.append(current + 1 + " ");
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[current][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void dfs(int current, boolean[] visited) {
		sb.append(current + 1 + " ");
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[current][i]) {
		        visited[i] = true;
                dfs(i, visited);
            }
		}
	}

}