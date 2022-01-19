import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static char[][] map;
	static int[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		max = 1;

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		go(0, 0, 1 << map[0][0] - 'A', 1);
		System.out.println(max);
	}
	
	private static void go(int r, int c, int bit, int cnt) {
		if (visited[r][c] == bit) return;
		visited[r][c] = bit;
		max = max > cnt ? max : cnt;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if ((bit & 1 << map[nr][nc] - 'A') != 0) continue; 
			go(nr, nc, bit | 1 << map[nr][nc] - 'A', cnt + 1);
		}
	}

}