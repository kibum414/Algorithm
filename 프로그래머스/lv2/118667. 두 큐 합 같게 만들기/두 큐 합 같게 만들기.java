import java.util.*;

class Solution {

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int len = queue1.length;
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < len; i++) {
            int n1 = queue1[i], n2 = queue2[i];

            q1.add(n1);
            sum1 += n1;

            q2.add(n2);
            sum2 += n2;
        }

        if ((sum1 + sum2) % 2 == 1) return -1;

        int answer = 0;

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                int n = q1.poll();
                
                q2.add(n);
                sum1 -= n;
                sum2 += n;
            } else {
                int n = q2.poll();
                
                q1.add(n);
                sum1 += n;
                sum2 -= n;
            }

            answer++;

            if (answer > len * 3) return -1;
        }

        return answer;

    }

}