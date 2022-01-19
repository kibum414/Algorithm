import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int R, C;
	static char chars[], map[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		chars = br.readLine().toCharArray();
		int size = chars.length;

		for (int i = 1; i <= size / 2; i++) {
			if (i <= size / i && size % i == 0) {
				R = i;
				C = size / i;
			}
		}

		map = new char[R][C];
		int index = 0;
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				map[r][c] = chars[index++];
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
		}

		System.out.println(sb);

	}

}