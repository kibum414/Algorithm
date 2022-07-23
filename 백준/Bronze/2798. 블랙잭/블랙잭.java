import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, num[], max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

		combination(0, 0, 0);

		System.out.println(max);

	}

	private static void combination(int cnt, int start, int sum) {
		if (cnt == 3) {
			max = Math.max(sum, max);
			return;
		}

		for (int i = start; i < N; i++) {
			if (sum + num[i] > M) continue;

			combination(cnt + 1, i + 1, sum + num[i]);
		}
	}

}