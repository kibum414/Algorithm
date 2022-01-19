import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], blue, white;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		blue = 0;
		white = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dc(0, 0, N);

		System.out.println(white);
		System.out.println(blue);

	}

	private static void dc(int r, int c, int n) {
		if (isSame(r, c, n)) {
			if (map[r][c] == 1) blue++;
			else white++;
		} else {
			dc(r, c, n / 2);
			dc(r, c + n / 2, n / 2);
			dc(r + n / 2, c, n / 2);
			dc(r + n / 2, c + n / 2, n / 2);
		}
	}

	private static boolean isSame(int r, int c, int n) {
		int color = map[r][c];
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (map[i][j] != color) return false;
			}
		}

		return true;
	}

}