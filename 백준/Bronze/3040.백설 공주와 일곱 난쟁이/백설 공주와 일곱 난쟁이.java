import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int dwarf[], p[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		p = new int[9];
		int cnt = 0;

		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		while (++cnt <= 7) p[9 - cnt] = 1;

		do {
			int sum = 0;

			for (int i = 0; i < 9; i++) {
				if (p[i] == 1) sum += dwarf[i];
			}

			if (sum == 100) break;
		} while (np());

		for (int i = 0; i < 9; i++) {
			if (p[i] == 1) System.out.println(dwarf[i]);
		}
	}

	private static boolean np() {
		int size = p.length;

		int i = size - 1;
		while (i > 0 && p[i - 1] >= p[i]) --i;

		if (i == 0) return false;

		int j = size - 1;
		while (p[i - 1] >= p[j]) --j;

		swap(i - 1, j);

		int k = size - 1;
		while (i < k) swap(i++, k--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}