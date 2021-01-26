public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] count = new int[256];
    
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            while (count[s.charAt(i)] > 1) {
                count[s.charAt(j)]--;
                j++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
}
