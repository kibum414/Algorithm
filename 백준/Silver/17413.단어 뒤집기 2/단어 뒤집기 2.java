import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (i < chars.length) {
			if (chars[i] == '<') {
				while (chars[i] != '>') i++;
				i++;
			} else if (chars[i] != ' ') {
				int start = i;
				while (i < chars.length && chars[i] != '<' && chars[i] != ' ') i++;
				int end = i - 1;

				while (start < end) wordFlip(chars, start++, end--);
			} else if (chars[i] == ' ') i++;
		}

		for (char c : chars) sb.append(c);
		System.out.println(sb);

	}

	private static void wordFlip(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

}