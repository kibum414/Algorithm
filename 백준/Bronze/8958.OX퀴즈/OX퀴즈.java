import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int T, sum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			int size = s.length();
			sum = 0;

			for (int i = 0; i < size; i++) {
				int count = 1;

				if (s.charAt(i) == 'O') {
					do {
						sum += count++;
					} while (++i < size && s.charAt(i) != 'X');
				}
			}

			System.out.println(sum);
		}

	}

}