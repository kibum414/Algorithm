class Solution {

    public int solution(String s) {

        int len = s.length();
        int answer = len;
        StringBuilder sb;

        for (int i = 1, l = len / 2; i <= l; i++) {
            sb = new StringBuilder();

            String sub1 = s.substring(0, i);
            int cnt = 1;

            for (int j = i; j <= len; j += i) {
                String sub2 = s.substring(j, Math.min(j + i, len));

                if (sub1.equals(sub2)) cnt++;
                else {
                    if (cnt > 1) sb.append(cnt);

                    sb.append(sub1);
                    sub1 = sub2;
                    cnt = 1;
                }
            }

            if (cnt > 1) sb.append(cnt);
            sb.append(sub1);

            answer = Math.min(answer, sb.length());
        }

        return answer;

    }

}