import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == '0') {
					r = i;
					c = j;
				}
			}
		}

		min = Integer.MAX_VALUE;
		bfs(r, c);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { r, c, 0, 0 });
		boolean[][][] visited = new boolean[1 << 6][N][M];
		int[] cur = new int[4];

		while (!queue.isEmpty()) {
			cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			int curK = cur[2];
			int curCnt = cur[3];

			if (visited[curK][curR][curC]) continue;
			visited[curK][curR][curC] = true;

			if (map[curR][curC] == '1') {
				min = min < curCnt ? min : curCnt;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				int tempK = curK;

				if (!isAvailable(nr, nc) || map[nr][nc] == '#') continue;

				char v = map[nr][nc];

				if (v >= 'A' && v <= 'F') {
					if ((curK & (1 << v - 'A')) > 0) queue.offer(new int[] { nr, nc, curK, curCnt + 1 });
					continue;
				}

				if (v >= 'a' && v <= 'f') tempK |= 1 << v - 'a';
				queue.offer(new int[] { nr, nc, tempK, curCnt + 1 });

			}
		}
	}

	private static boolean isAvailable(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}