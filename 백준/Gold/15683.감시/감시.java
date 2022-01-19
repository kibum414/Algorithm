import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min, zeroCnt, size;
	static char[][] map;
	static List<int[]> cctvList;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][][] cctv = {
			{ { 0 }, { 1 }, { 2 }, { 3 } }, 
			{ { 0, 1 }, { 2, 3 } },
			{ { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }, 
			{ { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } },
			{ { 0, 1, 2, 3 } }
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		cctvList = new ArrayList<int[]>();
		min = Integer.MAX_VALUE;
        zeroCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '0') zeroCnt++;
				else if (map[i][j] != '6') cctvList.add(new int[] { i, j, map[i][j] - '0' });
			}
		}

        size = cctvList.size();
		watch(map, 0, 0);

		System.out.println(min);
	}

	private static void watch(char[][] currentMap, int idx, int cnt) {
		if (idx == size) {
			int sum = zeroCnt - cnt;
            min = Math.min(min, sum);
			return;
		}

		int r = cctvList.get(idx)[0];
		int c = cctvList.get(idx)[1];
		int num = cctvList.get(idx)[2] - 1;
		int[][] currentCCTV = cctv[num];

		for (int i = 0; i < currentCCTV.length; i++) {
            int t = 0;
			char[][] temp = new char[N][M];
			for (int j = 0; j < N; j++) System.arraycopy(currentMap[j], 0, temp[j], 0, M);

            for (int j = 0; j < currentCCTV[i].length; j++) {
				int v = currentCCTV[i][j];
				int nr = r + dr[v];
				int nc = c + dc[v];

				while (isAvailable(nr, nc) && currentMap[nr][nc] != '6') {
					if (temp[nr][nc] == '0') {
						temp[nr][nc] = '#';
						t++;
					}
					nr += dr[v];
					nc += dc[v];
				}
			}

            watch(temp, idx + 1, cnt + t);
		}
	}

	private static boolean isAvailable(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}