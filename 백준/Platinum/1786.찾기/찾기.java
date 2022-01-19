import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int tLength = T.length, pLength = P.length;
		int[] pi = new int[pLength];

		for (int i = 1, j = 0; i < pLength; i++) {
			while (j > 0 && P[i] != P[j]) j = pi[j - 1];
			if (P[i] == P[j]) pi[i] = ++j;
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0, j = 0; i < tLength; i++) {
			while (j > 0 && T[i] != P[j]) j = pi[j - 1];
			if (T[i] == P[j]) {
				if (j == pLength - 1) {
					cnt++;
					list.add(i - j);
					j = pi[j];
				} else ++j;
			}
		}

		sb.append(cnt + "\n");
		if (cnt > 0) {
			for (int p : list) sb.append((p + 1) + " ");
		}
		System.out.println(sb);
	}

}