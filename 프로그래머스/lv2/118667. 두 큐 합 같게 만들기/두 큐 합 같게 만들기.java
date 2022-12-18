import java.util.*;

class Solution {

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int len = queue1.length;
        long s1 = 0, s2 = 0;

        for (int i = 0; i < len; i++) {
            int n1 = queue1[i], n2 = queue2[i];

            q1.add(n1);
            s1 += n1;

            q2.add(n2);
            s2 += n2;
        }

        if ((s1 + s2) % 2 != 0) return -1;

        int cnt = 0, n = 0;

        while (s1 != s2) {
            if (s1 > s2) {
                n = q1.poll();
                
                q2.add(n);
                s1 -= n;
                s2 += n;
            } else {
                n = q2.poll();
                
                q1.add(n);
                s1 += n;
                s2 -= n;
            }

            if (++cnt > len * 3) return -1;
        }

        return cnt;

    }

}