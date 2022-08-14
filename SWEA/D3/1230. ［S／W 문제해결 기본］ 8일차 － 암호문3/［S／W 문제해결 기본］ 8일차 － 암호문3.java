import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, x, y;
    static LinkedList<String> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            list = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                String cmd = st.nextToken();

                switch (cmd) {
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for (int j = x, len = x + y; j < len; j++) {
                            list.add(j, st.nextToken());
                        }

                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < y; j++) {
                            list.remove(x);
                        }

                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < y; j++) {
                            list.add(st.nextToken());
                        }

                        break;
                }
            }

            sb.append("#").append(t).append(" ");

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }

}