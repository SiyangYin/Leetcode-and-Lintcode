public class Solution2 {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        int maxLen = 0;
        int[] interval = new int[2];
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int l, r;
            if (i % 2 == 0) {
                l = r = i / 2;
            } else {
                l = i / 2;
                r = i / 2 + 1;
            }
            
            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                interval[0] = l + 1;
                interval[1] = r - 1;
            }
        }
        
        return s.substring(interval[0], interval[1] + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("aab"));
    }
}
