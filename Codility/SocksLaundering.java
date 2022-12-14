import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int solution(int K, int[] C, int[] D) {

        HashMap<Integer, Integer> cMap = new HashMap<>();
        HashMap<Integer, Integer> dMap = new HashMap<>();
        int answer = 0;

        for (int c : C) {
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }

        for (int d : D) {
            dMap.put(d, dMap.getOrDefault(d, 0) + 1);
        }

        List<Integer> keySet = cMap.keySet().stream().sorted((o1, o2) -> cMap.get(o2) - cMap.get(o1)).collect(Collectors.toList());

        for (int key : keySet) {
            int value = cMap.get(key);

            if (value % 2 == 1) {
                if (K > 0 && dMap.containsKey(key)) {
                    cMap.put(key, value + 1);
                    dMap.put(key, dMap.get(key) - 1);
                    K--;
                }
            }

            answer += cMap.get(key) / 2;
        }

        int remain = K / 2;

        for (int value : dMap.values()) {
            if (remain > 0) {
                int n = Math.min(value / 2, remain);
                answer += n;
                remain -= n;
            }
        }

        return answer;

    }

}
