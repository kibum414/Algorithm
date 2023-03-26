class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int idx1 = 0, idx2 = 0;
        int len1 = cards1.length, len2 = cards2.length, len = goal.length;
        
        for (int i = 0; i < len; i++) {
            String s = goal[i];

            if (idx1 < len1 && s.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < len2 && s.equals(cards2[idx2])) {
                idx2++;
            } else return "No";
        }

        return "Yes";

    }

}