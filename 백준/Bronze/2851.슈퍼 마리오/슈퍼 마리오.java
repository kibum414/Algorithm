import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0, temp;

		for (int i = 0; i < 10; i++) {
			temp = Integer.parseInt(br.readLine());
			if (sum + temp > 100) {
				temp += sum;
				if (100 - sum >= temp - 100) sum = temp;
				break;
			}
			sum += temp;
		}

		System.out.println(sum);
	}

}