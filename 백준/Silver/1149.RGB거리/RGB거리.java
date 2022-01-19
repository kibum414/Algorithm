import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, D[][];

	private static void dp(int i, int r, int g, int b) {
		int dR = D[i - 1][0], dG = D[i - 1][1], dB = D[i - 1][2];
		D[i][0] = dG < dB ? dG + r : dB + r;
		D[i][1] = dR < dB ? dR + g : dB + g;
		D[i][2] = dR < dG ? dR + b : dG + b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		D = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

            dp(i, r, g, b);
		}

		System.out.println(D[N][0] < D[N][1] && D[N][0] < D[N][2] ? D[N][0] : D[N][1] < D[N][2] ? D[N][1] : D[N][2]);
	}

}