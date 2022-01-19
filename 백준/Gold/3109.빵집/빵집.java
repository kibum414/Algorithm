import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, cnt;
	static char[][] map;
	static boolean isFinished;
	static int dr[] = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		cnt = 0;

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			isFinished = false;
			store(i, 0);
		}

		System.out.println(cnt);
	}

	private static void store(int r, int c) {
		if (c == C - 1) {
			cnt++;
			isFinished = true;
			return;
		}

		map[r][c++] = 'x';

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			if (nr >= 0 && nr < R && map[nr][c] == '.') {
				store(nr, c);
				if (isFinished) return;
			}
		}
	}

}