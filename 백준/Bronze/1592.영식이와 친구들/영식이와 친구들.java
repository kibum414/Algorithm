import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, L, cnt[], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		cnt = new int[N];
		answer = 0;

		int n = 0;
		cnt[n] = 1;
		do {
			answer++;

			if (cnt[n] % 2 == 0) n = (n - L < 0) ? n + N - L : n - L;
			else n = (n + L > N - 1) ? n + L - N : n + L;
		} while (++cnt[n] != M);

		System.out.println(answer);
	}

}