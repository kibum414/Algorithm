import java.util.Scanner;

/*
 * 하노이 탑 이동 순서
 * 입력
 * 3
 * 출력
 * 
 */
public class Main {
	private static int N;
	private static int count;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		count = 0;
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(count);
		System.out.println(sb);
		
	}

	private static void hanoi(int n, int start, int temp, int dest) {
		
		count++;
		
		if (n == 1) {
			sb.append(start + " " + dest + "\n");
			
			return;
		}
		
		// (n - 1)개를 1에서 2로 이동
		hanoi(n - 1, start, dest, temp);
		
		// 가장 큰 원판을 1에서 3으로 이동
		sb.append(start + " " + dest + "\n");
		
		// (n - 1)개를 2에서 3으로 이동
		hanoi(n - 1, temp, start, dest);
		
	}
	
}
