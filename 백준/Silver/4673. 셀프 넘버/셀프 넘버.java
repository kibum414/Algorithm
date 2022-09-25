public class Main {

    static boolean[] check;

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) check[n] = true;
        }

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);

    }

    private static int d(int n) {

        int sum = n;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;

    }

}