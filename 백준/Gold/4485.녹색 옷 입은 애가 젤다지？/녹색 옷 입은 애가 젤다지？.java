import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], t, min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	static class Zelda implements Comparable<Zelda> {
		int r, c, rupee;

		public Zelda(int r, int c, int rupee) {
			super();
			this.r = r;
			this.c = c;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Zelda o) {
			return Integer.compare(this.rupee, o.rupee);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			bfs();
		}

		System.out.println(sb);
	}

	private static void bfs() {
		PriorityQueue<Zelda> pq = new PriorityQueue<Zelda>();
		pq.offer(new Zelda(0, 0, map[0][0]));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		Zelda cur = null;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			int rupee = cur.rupee;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr == N - 1 && nc == N - 1) {
					sb.append("Problem " + (t++) + ": " + (rupee + map[nr][nc]) + "\n");
					return;
				}

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					pq.offer(new Zelda(nr, nc, rupee + map[nr][nc]));
				}
			}
		}
	}

}