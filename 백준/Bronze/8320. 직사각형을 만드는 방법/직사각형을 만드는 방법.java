import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		int i = 1;

		while (i * i <= n) {
			int j = i;
			while (i * j++ <= n) cnt++;
			i++;
		}

		System.out.println(cnt);
	}

}