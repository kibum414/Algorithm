class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0, cnt = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
                continue;
            }
            
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    cnt++;
                    break;
                }
            }
        }

        return new int[]{Math.min(7 - (zeroCnt + cnt), 6), Math.min((7 - cnt), 6)};

    }

}