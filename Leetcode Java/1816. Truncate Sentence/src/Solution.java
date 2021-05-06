public class Solution {
    public String truncateSentence(String s, int k) {
        int idx = 0, cnt= 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == ' ') {
                cnt++;
            }
            
            if (cnt == k) {
                return s.substring(0, idx);
            }
            
            idx++;
        }
        
        return s;
    }
}
