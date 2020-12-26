public class Solution2 {
    /**
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return 0;
        }
        
        int[] zcount = new int[strs.length], ocount = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zcount[i]++;
                } else {
                    ocount[i]++;
                }
            }
        }
        
        int[][][] dp = new int[2][m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (k == 0) {
                        dp[k][i][j] = i >= zcount[0] && j >= ocount[0] ? 1 : 0;
                    } else {
                        dp[k & 1][i][j] = dp[k - 1 & 1][i][j];
                        if (i >= zcount[k] && j >= ocount[k]) {
                            dp[k & 1][i][j] = Math.max(dp[k & 1][i][j], 1 + dp[k - 1 & 1][i - zcount[k]][j - ocount[k]]);
                        }
                    }
                }
            }
        }
        
        return dp[strs.length - 1 & 1][m][n];
    }
    
    
}
