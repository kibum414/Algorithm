class Solution {
    
    public boolean solution(String s) {
        
        boolean answer = true;
        int len = s.length();
        
        if (len != 4 && len != 6) return false;
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) continue;

            answer = false;
            
            break;
        }
        
        return answer;
        
    }
}