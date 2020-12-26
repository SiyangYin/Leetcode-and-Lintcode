public class Solution {
    /**
     * @param n: the number of tasks
     * @param weights: the weight for every task
     * @param tasks: the actual duration of every task
     * @param p: maximum runtime for Pigeon in an hour
     * @return: the maximum total weight that the Pigeon service can achieve in an hour
     */
    public int maxWeight(int n, int[] weights, int[] tasks, int p) {
        // write your code here
        int[][] dp = new int[n + 1][p / 2 + 1];
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p / 2; j++) {
                if (j < tasks[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + weights[i - 1]);
                }
            }
        }
        
        return dp[n][p / 2];
    }
}
