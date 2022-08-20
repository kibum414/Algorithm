import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, map[][], count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		count = N > M ? M / 2 : N / 2;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) turnArray(0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void turnArray(int cnt) {
		int temp = map[cnt][cnt];

		for (int i = cnt; i < M - cnt - 1; i++) {
			map[cnt][i] = map[cnt][i + 1];
		}
		for (int i = cnt; i < N - cnt - 1; i++) {
			map[i][M - cnt - 1] = map[i + 1][M - cnt - 1];
		}
		for (int i = M - cnt - 1; i > cnt; i--) {
			map[N - cnt - 1][i] = map[N - cnt - 1][i - 1];
		}
		for (int i = N - cnt - 1; i > cnt; i--) {
			map[i][cnt] = map[i - 1][cnt];
		}
		map[cnt + 1][cnt] = temp;
		if (++cnt == count) return;

		turnArray(cnt);
	}

}