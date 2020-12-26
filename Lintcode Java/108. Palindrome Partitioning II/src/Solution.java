import java.util.Arrays;

public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int l = i, r = i + len - 1;
                if (len == 1) {
                    isPalin[l][r] = true;
                } else {
                    isPalin[l][r] = s.charAt(l) == s.charAt(r);
                    if (len > 2) {
                        isPalin[l][r] &= isPalin[l + 1][r - 1];
                    }
                }
            }
        }
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp, s.length() - 1);
    
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalin[j][i]) {
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[j - 1]);
                    }
                }
            }
        }
        
        return dp[s.length() - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aab"));
    }
}
