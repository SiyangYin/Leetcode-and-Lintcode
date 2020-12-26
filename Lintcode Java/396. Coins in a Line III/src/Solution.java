public class Solution {
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
        
        int len = values.length;
        
        return dfs(0, len - 1, new int[len][len], values) > 0;
    }
    
    private int dfs(int i, int j, int[][] dp, int[] values) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        if (i == j) {
            dp[i][i] = values[i];
            return values[i];
        }
        
        int r1 = values[i] - dfs(i + 1, j, dp, values), r2 = values[j] - dfs(i, j - 1, dp, values);
        dp[i][j] = Math.max(r1, r2);
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstWillWin(new int[]{1, 20, 4}));
    }
}
