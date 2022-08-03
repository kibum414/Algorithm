import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class point implements Comparable<point> {
		int row, col, cost;

		public point(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(point o) {
			return this.cost - o.cost;// 오름차순 정렬(return값이 양수일 때 자리 바꿈)

		}
	}

	static int N, k;
	static int tc = 0;
	static int[][] map, dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			tc++;
			N = in.nextInt();
			if (N == 0)
				break;
			map = new int[N][N];
			dist = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = in.nextInt();
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
			System.out.println("Problem " + tc + ": " + dijkstra());
		}
		in.close();
	}

	public static int dijkstra() {
		PriorityQueue<point> pq = new PriorityQueue<point>();
		dist[0][0] = map[0][0]; // 초기 값
		pq.offer(new point(0, 0, map[0][0]));// 시작 좌표
		while (!pq.isEmpty()) {
			point p = pq.poll();
			int r = p.row;
			int c = p.col;
			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = p.row + dr[d];
				int nc = p.col + dc[d];

				// 범위체크
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
						dist[nr][nc] = dist[r][c] + map[nr][nc];
						pq.offer(new point(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
		return dist[N - 1][N - 1];
	}
}
