public class Solution {
    /**
     * @param s: the string
     * @return: length of longest semi alternating substring
     */
    public int longestSemiAlternatingSubstring(String s) {
        // write your code here
        int res = 0, count = 0;
        char ch = 0;
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != ch) {
                ch = s.charAt(i);
                count = 1;
            } else {
                count++;
                if (count >= 3) {
                    j = i - 1;
                }
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestSemiAlternatingSubstring("baaabbabbb"));
        System.out.println(new Solution().longestSemiAlternatingSubstring("aaaaaaaaaaaaaaa"));
    }
}
