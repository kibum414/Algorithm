import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        return binarySearch(n, times, times[times.length - 1]);
        
    }
    
    private static long binarySearch(int n, int[] times, long max) {
        
        long start = 1;
        long end = max * n;
        long mid = 0;
        long answer = Long.MAX_VALUE;
        
        while (start <= end) {
            mid = (start + end) / 2;
            
            if (isInRange(n, times, mid)) {
                answer = mid < answer ? mid : answer;
                end = mid - 1;
            } else start = mid + 1;
        }
        
        return answer;
        
    }
    
    private static boolean isInRange(int n, int[] times, long mid) {
        
        long amount = 0;
        
        for (int i = 0, len = times.length; i < len; i++) {
            amount += mid / times[i];
        }
        
        if (amount >= n) return true;
        else return false;
        
    }
    
}