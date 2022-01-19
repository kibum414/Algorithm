import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		S = br.readLine();
		int i = 0, size = S.length();

		while (i < size) {
			switch (S.charAt(i)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				sb.append(S.charAt(i));
				i += 3;
				break;
			default:
				sb.append(S.charAt(i));
				i++;
			}
		}

		System.out.println(sb);
	}

}