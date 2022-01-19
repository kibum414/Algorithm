import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H, map[][];
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0, -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0, 0, 0 });
		visited = new boolean[H][W][K + 1];
		visited[0][0][0] = true;

		int[] cur = new int[4];
		while (!queue.isEmpty()) {
			cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int k = cur[2];
			int cnt = cur[3];

			if (r == H - 1 && c == W - 1) return cnt;

			for (int i = 0; i < 12; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0) {
					if (i < 4) {
						if (!visited[nr][nc][k]) {
							visited[nr][nc][k] = true;
							queue.offer(new int[] { nr, nc, k, cnt + 1 });
						}
					} else {
						if (k == K) break;

						if (!visited[nr][nc][k + 1]) {
							visited[nr][nc][k + 1] = true;
							queue.offer(new int[] { nr, nc, k + 1, cnt + 1 });
						}
					}
				}
			}
		}

		return -1;
	}

}