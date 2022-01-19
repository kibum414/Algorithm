import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, D, map[][], temp[][], max;
	static boolean[][] isAttacked;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		temp = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		while (++cnt <= 3) map[N][M - cnt]++;

		do {
			copyMap();
			defense();
		} while (np());

		System.out.println(max);

	}

	private static void copyMap() {
		for (int i = 0; i <= N; i++) System.arraycopy(map[i], 0, temp[i], 0, M);
	}

	private static void defense() {
		int sum = 0, cnt = 0;

		while (++cnt <= N) {
			isAttacked = new boolean[N][M];

			for (int m = 0; m < M; m++) {
				if (temp[N][m] == 1) {
					int d = Integer.MAX_VALUE;
					int i = 0, j = 0;
					for (int r = N - 1; r >= 0; r--) {
						for (int c = 0; c < M; c++) {
							if (temp[r][c] == 1) {
								int dTemp = (N - r) + Math.abs(m - c);

								if (dTemp < d) {
									d = dTemp;
									i = r;
									j = c;
								} else if (dTemp == d && c < j) {
									i = r;
									j = c;
								}

							}
						}
					}
					if (d <= D) isAttacked[i][j] = true;
				}
			}

			for (int r = N - 1; r >= 0; r--) {
				for (int c = 0; c < M; c++) {
					if (isAttacked[r][c]) {
						temp[r][c] = 0;
						sum++;
					}
				}
			}

			move();
		}

		max = Math.max(max, sum);
	}

	private static void move() {
		for (int c = 0; c < M; c++) {
			for (int r = N - 1; r > 0; r--) temp[r][c] = temp[r - 1][c];
			temp[0][c] = 0;
		}
	}

	private static boolean np() {
		int i = M - 1;
		while (i > 0 && map[N][i - 1] >= map[N][i]) --i;

		if (i == 0) return false;

		int j = M - 1;
		while (map[N][i - 1] >= map[N][j]) --j;

		swap(i - 1, j);

		int k = M - 1;
		while (i < k) swap(i++, k--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = map[N][i];
		map[N][i] = map[N][j];
		map[N][j] = temp;
	}

}