import java.util.Arrays;

public class Solution {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int[][][] dp = new int[s1.length()][s2.length()][len + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return check(s1, s2, 0, 0, len, dp);
    }
    
    private boolean check(String s1, String s2, int idx1, int idx2, int len, int[][][] dp) {
        if (dp[idx1][idx2][len] != -1) {
            System.out.println("haha");
            return dp[idx1][idx2][len] == 1;
        }
        
        if (s1.substring(idx1, idx1 + len).equals(s2.substring(idx2, idx2 + len))) {
            dp[idx1][idx2][len] = 1;
            return true;
        }
        
        int[] count = new int[26];
        for (int i = idx1; i < idx1 + len; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = idx2; i < idx2 + len; i++) {
            char ch = s2.charAt(i);
            if (count[ch - 'a'] == 0) {
                dp[idx1][idx2][len] = 0;
                return false;
            }
            count[ch - 'a']--;
        }
        
        for (int l = 1; l < len; l++) {
            if (check(s1, s2, idx1, idx2, l, dp) && check(s1, s2, idx1 + l, idx2 + l, len - l, dp)) {
                dp[idx1][idx2][len] = 1;
                return true;
            }
            if (check(s1, s2, idx1, idx2 + len - l, l, dp) && check(s1, s2, idx1 + l, idx2, len - l, dp)) {
                dp[idx1][idx2][len] = 1;
                return true;
            }
        }
        
        dp[idx1][idx2][len] = 0;
        return false;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().isScramble("great", "rgeat"));
        System.out.println(new Solution().isScramble("abcdbdacbdac", "bdacabcdbdac"));
        // System.out.println(new Solution().isScramble("a", "r"));
        // System.out.println(new Solution().isScramble("ar", "ra"));
    }
}
