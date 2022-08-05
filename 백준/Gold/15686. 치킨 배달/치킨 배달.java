import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, S, chickenIndex[], cityMin;
	static ArrayList<int[]> chicken, home;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<int[]>();
		home = new ArrayList<int[]>();
		cityMin = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) home.add(new int[] { i, j });
				if (value == 2) chicken.add(new int[] { i, j });
			}
		}

		S = chicken.size();
		chickenIndex = new int[S];
		int cnt = 0;
		while (++cnt <= M) chickenIndex[S - cnt]++;

		do {
			calcDistance();
		} while (np(chickenIndex));

		System.out.println(cityMin);

	}

	private static void calcDistance() {
		int sum = 0;

		for (int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < S; j++) {
				if (chickenIndex[j] == 1) {
					int d = Math.abs(chicken.get(j)[0] - home.get(i)[0]) + Math.abs(chicken.get(j)[1] - home.get(i)[1]);
					min = min < d ? min : d;
				}
			}
			sum += min;
		}

		cityMin = cityMin < sum ? cityMin : sum;
	}

	private static boolean np(int[] num) {
		int i = S - 1;
		while (i > 0 && num[i - 1] >= num[i]) --i;

		if (i == 0) return false;

		int j = S - 1;
		while (num[i - 1] >= num[j]) --j;

		swap(num, i - 1, j);

		int k = S - 1;
		while (i < k) swap(num, i++, k--);

		return true;
	}

	private static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}