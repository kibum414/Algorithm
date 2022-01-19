import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int sudoku[][], horizontal[], vertical[], square[], size;
	static ArrayList<int[]> list;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		horizontal = new int[9];
		vertical = new int[9];
		square = new int[9];
		list = new ArrayList<int[]>();
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';

				int n = sudoku[i][j];
				if (n == 0) {
					list.add(new int[] { i, j });
				} else {
					horizontal[i] |= 1 << n;
					vertical[j] |= 1 << n;
					square[(i / 3) * 3 + j / 3] |= 1 << n;
				}
			}
		}
		flag = false;
		size = list.size();

		play(0);
		print();
	}

	private static void play(int cnt) {
		if (cnt == size) {
			flag = true;
			return;
		}

		int r = list.get(cnt)[0];
		int c = list.get(cnt)[1];

		for (int i = 1; i < 10; i++) {
			if ((horizontal[r] & 1 << i) > 0 || (vertical[c] & 1 << i) > 0 || (square[(r / 3) * 3 + c / 3] & 1 << i) > 0) continue;

			sudoku[r][c] = i;
			horizontal[r] |= 1 << i;
			vertical[c] |= 1 << i;
			square[(r / 3) * 3 + c / 3] |= 1 << i;

			play(cnt + 1);
			if (flag) return;

			sudoku[r][c] = 0;
			horizontal[r] -= 1 << i;
			vertical[c] -= 1 << i;
			square[(r / 3) * 3 + c / 3] -= 1 << i;
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int[] arr : sudoku) {
			for (int n : arr) {
				sb.append(n);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}