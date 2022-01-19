import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, map[][], cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		quadTree(N, 0, 0);
		System.out.println(sb);
	}

	private static void quadTree(int n, int r, int c) {
		if (isSame(n, r, c)) {
			sb.append(map[r][c]);
			return;
		}
        sb.append("(");
        quadTree(n / 2, r, c);
        quadTree(n / 2, r, c + n / 2);
        quadTree(n / 2, r + n / 2, c);
        quadTree(n / 2, r + n / 2, c + n / 2);
		sb.append(")");
	}

	private static boolean isSame(int n, int r, int c) {
		int temp = map[r][c];

		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (map[i][j] != temp) return false;
			}
		}

		return true;
	}

}