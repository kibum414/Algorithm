import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, p[], sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(p);
		for (int i = 0; i < N; i++) sum += p[i] * (N - i);

		System.out.println(sum);

	}

}