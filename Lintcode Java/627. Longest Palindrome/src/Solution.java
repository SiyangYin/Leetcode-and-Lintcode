public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int[] alpha = new int[26];
        int[] Alpha = new int[26];
    
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a') {
                alpha[s.charAt(i) - 'a']++;
            } else {
                Alpha[s.charAt(i) - 'A']++;
            }
        }
        
        int len = s.length();
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                len--;
            }
            if (Alpha[i] % 2 != 0) {
                len--;
            }
        }
        
        return len == s.length() ? len : len + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
        System.out.println(new Solution().longestPalindrome("NTrQdQGgwtxqRTSBOitAXUkwGLgUHtQOmYMwZlUxqZysKpZxRoehgirdMUgy"));
    }
}
