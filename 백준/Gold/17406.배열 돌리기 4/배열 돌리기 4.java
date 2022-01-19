import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, map[][], copy[][], input[][], R, C, S, p[], min;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy = new int[N][M];
		input = new int[K][3];
		p = new int[K];
		isSelected = new boolean[K];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			input[k][0] = Integer.parseInt(st.nextToken());
			input[k][1] = Integer.parseInt(st.nextToken());
			input[k][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0);

		System.out.println(min);

	}

	private static void turnArray(int r, int c, int s) {
		if (s != 0) {
			int rEnd = r + s;
			int cEnd = c + s;
			int temp = copy[r][c];

			for (int i = r; i < rEnd; i++) { // 좌
				copy[i][c] = copy[i + 1][c];
			}
			for (int i = c; i < cEnd; i++) { // 하
				copy[rEnd][i] = copy[rEnd][i + 1];
			}
			for (int i = rEnd; i > r; i--) { // 우
				copy[i][cEnd] = copy[i - 1][cEnd];
			}
			for (int i = cEnd; i > c; i--) { // 상
				copy[r][i] = copy[r][i - 1];
			}

			copy[r++][++c] = temp;
		} else return;

		turnArray(r, c, s - 2);
	}

	private static void findMin() {
		for (int i = 0; i < N; i++) {
			int sum = 0;

			for (int j = 0; j < M; j++) {
				sum += copy[i][j];
			}

			min = Math.min(sum, min);
		}
	}

	private static void permutation(int cnt) {
		if (cnt == K) {
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, M);
			}

			for (int k = 0; k < K; k++) {
				R = input[p[k]][0];
				C = input[p[k]][1];
				S = input[p[k]][2];

				turnArray(R - S - 1, C - S - 1, S * 2);
			}

			findMin();

			return;
		}

		for (int i = 0; i < K; i++) {
			if (isSelected[i]) continue;

			p[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

}