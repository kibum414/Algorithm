import java.util.*;

class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        Map<Integer, Boolean> map = new HashMap<>();
        int zeroCnt = 0, sameCnt = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
                continue;
            }
            
            map.put(lotto, true);
        }

        for (int win_num : win_nums) {
            if (map.containsKey(win_num)) sameCnt++;
        }

        return new int[]{Math.min(7 - (zeroCnt + sameCnt), 6), Math.min((7 - sameCnt), 6)};

    }

}