import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, map[][], cleaner;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] direction = { { 0, 3, 1, 2 }, { 1, 3, 0, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] < 0) cleaner = i;
			}
		}
		cleaner--;

		for (int t = 1; t <= T; t++) {
			spread();
			clean();
		}

		System.out.println(calcSum());
	}

	private static void spread() {
		int[][] temp = new int[R][C];

		temp[cleaner][0] = -1;
		temp[cleaner + 1][0] = -1;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 0) {
					int n = map[r][c] / 5;
					int cnt = 0;

					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;

						temp[nr][nc] += n;
						cnt++;
					}

					temp[r][c] += map[r][c] - n * cnt;
				}
			}
		}

		map = temp;
	}

	private static void clean() {
		for (int i = 0; i < 2; i++) {
			int r = cleaner + i;
			int c = 0;
			int d = 0;
			int top, bottom;

			if (i == 0) {
				top = 0;
				bottom = r + 1;
			} else {
				top = r;
				bottom = R;
			}

			while (true) {
				int nr = r + dr[direction[i][d]];
				int nc = c + dc[direction[i][d]];

				if (nr < top || nr >= bottom || nc < 0 || nc >= C) {
					d = (d + 1) % 4;
					continue;
				}

				if (map[nr][nc] == -1) {
					map[r][c] = 0;
					break;
				}

				if (map[r][c] != -1) map[r][c] = map[nr][nc];

				r = nr;
				c = nc;
			}
		}
	}

	private static int calcSum() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) sum += map[i][j];
			}
		}
		return sum;
	}

}