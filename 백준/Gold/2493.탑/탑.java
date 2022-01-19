import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		Stack<int[]> tower = new Stack<int[]>();
		
		for (int i = 1; i <= N; i++) {
			int t = Integer.parseInt(st.nextToken());
			
			while (!tower.isEmpty()) {
				if (t <= tower.peek()[1]) {
					sb.append(tower.peek()[0] + " ");
					break;
				} else {
					tower.pop();
				}
			}
			
			if (tower.isEmpty()) sb.append("0 ");
			
			tower.push(new int[] {i, t});
		}

		System.out.println(sb);

	}

}
