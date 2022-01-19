import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Vertex implements Comparable<Vertex> {
		int no, distance;
		Vertex link;

		public Vertex(int no, int distance, Vertex link) {
			super();
			this.no = no;
			this.distance = distance;
			this.link = link;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.distance, o.distance);
		}
	}

	static int V, E, K;
	static Vertex[] adjList;
	static final int INFINITY = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adjList = new Vertex[V + 1];
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u] = new Vertex(v, w, adjList[u]);
		}

		Arrays.fill(distance, INFINITY);
		distance[K] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(K, distance[K], adjList[K]));
		Vertex current = null;
		while (!pq.isEmpty()) {
			current = pq.poll();
			if (visited[current.no]) continue;
			visited[current.no] = true;

			for (Vertex temp = current; temp != null; temp = temp.link) {
				if (!visited[temp.no] && distance[temp.no] > distance[current.no] + temp.distance) {
					distance[temp.no] = distance[current.no] + temp.distance;
					pq.offer(new Vertex(temp.no, distance[temp.no], adjList[temp.no]));
				}
			}
		}

        StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INFINITY) sb.append("INF\n");
			else sb.append(distance[i] + "\n");
		}
		System.out.println(sb);
	}

}