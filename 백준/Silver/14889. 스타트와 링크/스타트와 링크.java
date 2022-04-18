import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static int[][] S;
    static boolean[] team;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        team = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        System.out.println(min);

    }

    public static void combination(int start, int cnt) {

        if (cnt == N / 2) {
            int difference = calcStat();

            if (difference == 0) {
                System.out.println(difference);

                System.exit(0);
            }

            min = Math.min(min, difference);

            return;
        }

        for (int i = start; i < N; i++) {
            team[i] = true;
            combination(i + 1, cnt + 1);
            team[i] = false;
        }

    }

    public static int calcStat() {

        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] && team[j]) startSum += S[i][j];
                else if (!team[i] && !team[j]) linkSum += S[i][j];
            }
        }

        return Math.abs(startSum - linkSum);

    }

}