import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, map[][], tomato, day;
	static Queue<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<int[]>();
		day = tomato = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) queue.offer(new int[] { i, j, 0 });
				else if (map[i][j] == 0) tomato++;
			}
		}

		if (tomato != 0) {
			bfs();
			if (tomato > 0) day = -1;
		}
		System.out.println(day);
	}

	private static void bfs() {
		int[] cur = new int[3];

		while (!queue.isEmpty()) {
			cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			day = cur[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0) {
						queue.offer(new int[] { nr, nc, day + 1 });
						map[nr][nc] = 1;
						tomato--;
					}
				}
			}
		}
	}

}