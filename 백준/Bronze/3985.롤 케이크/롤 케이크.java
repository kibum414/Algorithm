import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int L, N, cake[], p, k, max, minIdx, realMax, realMinIdx, count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		cake = new int[L + 1];

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int temp = k - p + 1;
			count = 0;

			if (max < temp) {
				max = temp;
				minIdx = n;
			}

			for (int i = p; i <= k; i++) {
				if (cake[i] != 0) continue;
				cake[i] = n;
				count++;
			}

			if (realMax < count) {
				realMax = count;
				realMinIdx = n;
			}
		}

		System.out.println(minIdx);
		System.out.println(realMinIdx);

	}

}