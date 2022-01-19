import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, cnt;
	static char[] seats;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seats = br.readLine().toCharArray();
		cnt = 0;
		int i = 0;

		while (i < N) {
			cnt++;
			if (seats[i] == 'S') {
				while (++i < N && seats[i] == 'S') cnt++;
			} else i += 2;
		}

		System.out.println(++cnt > N ? N : cnt);
	}

}