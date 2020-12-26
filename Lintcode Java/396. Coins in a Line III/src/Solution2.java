public class Solution2 {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length % 2 == 0) {
            int odd = 0, even = 0;
            for (int i = 0; i < values.length; i++) {
                if (i % 2 == 0) {
                    even += values[i];
                } else {
                    odd += values[i];
                }
            }
        
            return odd != even;
        }
        
        int[][] dp = new int[values.length][values.length];
        for (int len = 1; len <= values.length; len++) {
            for (int i = 0; i + len - 1 < values.length; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][i] = values[i];
                } else {
                    dp[i][j] = Math.max(values[i] - dp[i + 1][j], values[j] - dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][values.length - 1] > 0;
    }
}
