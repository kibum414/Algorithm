class Solution {
    
    static String[] W;
    static boolean[] visit;
    static int len, answer;

    public int solution(String begin, String target, String[] words) {

        answer = 51;
        W = words;
        len = W.length;
        visit = new boolean[len];

        dfs(begin, target, 0);

        if (answer == 51) return 0;

        return answer;

    }
    
    private static void dfs(String begin, String target, int cnt) {

        if (begin.equals(target)) {
            answer = cnt;

            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visit[i] && check(begin, W[i])) {
                visit[i] = true;
                dfs(W[i], target, cnt + 1);
                visit[i] = false;
            }
        }

    }

    private static boolean check(String s1, String s2) {

        int cnt = 0;

        for (int i = 0, sLen = s1.length(); i < sLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }

        return true;

    }

}