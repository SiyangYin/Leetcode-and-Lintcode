public class Solution {
    /**
     * @param s: The capacity of backpack
     * @param v: The value of goods
     * @param c: The capacity of goods
     * @return: The answer
     */
    public long getMaxValue(int s, int[] v, int[] c) {
        // Write your code here
        long[][] dp = new long[2][s + 1];
        for (int i = c[0]; i <= s; i++) {
            dp[0][i] = v[0];
        }
    
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i & 1][j] = dp[i - 1 & 1][j];
                if (j >= c[i]) {
                    dp[i & 1][j] = Math.max(dp[i & 1][j], v[i] + dp[i - 1 & 1][j - c[i]]);
                }
            }
        }
        
        return dp[v.length - 1 & 1][s];
    }
}
