import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], copiedMap[][], safe, virus;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copiedMap = new int[N][M];
		safe = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) safe++;
			}
		}

		virus = safe;
		build(0, 0, 0);

		System.out.println(safe - virus - 3);

	}

	private static void build(int r, int c, int cnt) {
		if (cnt == 3) {
			int temp = bfs();
			virus = virus < temp ? virus : temp;
			return;
		}

		for (int i = r; i < N; i++) {
			for (int j = c; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					build(i, j, cnt + 1);
					map[i][j] = 0;
				}
			}
			c = 0;
		}
	}

	private static int bfs() {
		int cnt = 0;
		copyArr();

		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copiedMap[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		int[] cur = new int[2];
		while (!queue.isEmpty()) {
			cur = queue.poll();
			int r = cur[0];
			int c = cur[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (copiedMap[nr][nc] == 0) {
						copiedMap[nr][nc] = 2;
						queue.offer(new int[] { nr, nc });
						cnt++;
					}
				}
			}
		}

		return cnt;
	}

	private static void copyArr() {
		for (int i = 0; i < N; i++) {
			copiedMap[i] = Arrays.copyOf(map[i], M);
		}
	}

}