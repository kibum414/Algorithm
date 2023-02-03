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

        int temp = 7 - sameCnt;

        return new int[]{Math.min(temp - zeroCnt, 6), Math.min(temp, 6)};

    }

}