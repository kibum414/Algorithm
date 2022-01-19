import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c, sushi[], checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		checked = new int[d + 1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(eat());
	}

	private static int eat() {
		int cnt = 0, max = 0;

		for (int i = 0; i < k; i++) {
			if (checked[sushi[i]]++ == 0) cnt++;
		}

		for (int i = 1; i <= N; i++) {
			if (max <= cnt) {
				max = cnt;
				if (checked[c] == 0) max++;
			}

			if (--checked[sushi[i - 1]] == 0) cnt--;
			if (checked[sushi[(i + k - 1) % N]]++ == 0) cnt++;
		}

		return max;
	}

}