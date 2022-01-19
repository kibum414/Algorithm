import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] n = new int[3];
		n[0] = Integer.parseInt(st.nextToken());
		n[1] = Integer.parseInt(st.nextToken());
		n[2] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (n[i] > n[j]) {
					int temp = n[j];
					n[j] = n[i];
					n[i] = temp;
				}
			}
		}

		System.out.println(n[1]);
	}

}