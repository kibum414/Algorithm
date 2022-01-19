import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, map[][], time, remain, cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		time = remain = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) remain++;
			}
		}

		while (true) {
			cnt = 0;

			dfs(0, 0);
			meltCheese();
			refresh();
			countCheese();

			time++;
			if (cnt == 0) break;
			remain = cnt;
		}

		sb.append(time + "\n" + remain);
		System.out.println(sb);
	}

	private static void countCheese() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) cnt++;
			}
		}
	}

	private static void dfs(int r, int c) {
		map[r][c] = 2;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) dfs(nr, nc);
		}
	}

	private static void meltCheese() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 2) map[r][c] = 0;
					}
				}
			}
		}
	}

	private static void refresh() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 2) map[r][c] = 0;
			}
		}
	}

}