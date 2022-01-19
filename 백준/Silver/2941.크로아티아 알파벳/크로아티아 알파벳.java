import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String S, ca[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		ca = new String[] { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (String s : ca) {
			if (S.contains(s)) S = S.replace(s, "!");
		}

		System.out.println(S.length());
	}

}