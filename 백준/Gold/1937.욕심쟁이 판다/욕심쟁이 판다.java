import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, map[][], dp[][], max;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 2][n + 2];
		dp = new int[n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int temp = dfs(i, j);
				max = max > temp ? max : temp;
			}
		}

		System.out.println(max);
	}

	private static int dfs(int r, int c) {
		if (dp[r][c] > 0) {
			return dp[r][c];
		}

		dp[r][c] = 1;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];

			if (map[nr][nc] != 0 && map[r][c] < map[nr][nc]) {
				dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
			}
		}

		return dp[r][c];
	}

}