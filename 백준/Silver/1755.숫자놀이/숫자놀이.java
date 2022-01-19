import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int M, N, size;
	static String[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		size = N - M + 1;
		str = new String[size];

		for (int i = M, j = 0; i <= N; i++) {
			String s = null;
			int one = i % 10;

			if (i < 10) {
				s = numToStr(one);
			} else {
				int ten = i / 10;
				s = numToStr(ten) + " ";
				s += numToStr(one);
			}

			str[j++] = s;
		}

		Arrays.sort(str);

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			String[] num = str[i].split(" ");

			if (num.length == 1) System.out.print(strToNum(num[0]) + " ");
			else System.out.print(strToNum(num[0]) * 10 + strToNum(num[1]) + " ");
			if (++cnt % 10 == 0) System.out.println();
		}
	}

	private static String numToStr(int n) {
		String s = null;

		switch (n) {
		case 0: s = "zero"; break;
		case 1: s = "one"; break;
		case 2: s = "two"; break;
		case 3: s = "three"; break;
		case 4: s = "four"; break;
		case 5: s = "five"; break;
		case 6: s = "six"; break;
		case 7: s = "seven"; break;
		case 8: s = "eight"; break;
		case 9: s = "nine"; break;
		}

		return s;
	}

	private static int strToNum(String s) {
		int n = 0;

		switch (s) {
		case "zero": n = 0; break;
		case "one": n = 1; break;
		case "two": n = 2; break;
		case "three": n = 3; break;
		case "four": n = 4; break;
		case "five": n = 5; break;
		case "six": n = 6; break;
		case "seven": n = 7; break;
		case "eight": n = 8; break;
		case "nine": n = 9; break;
		}

		return n;
	}

}