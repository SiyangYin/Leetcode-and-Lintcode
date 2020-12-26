public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        
        int cur = 0;
        for (int i = 1; i < costs.length; i++) {
            cur ^= 1;
            for (int j = 0; j < 3; j++) {
                dp[cur][j] = costs[i][j] + Math.min(dp[cur ^ 1][(j + 1) % 3], dp[cur ^ 1][(j + 2) % 3]);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[cur][i]);
        }
        
        return res;
    }
}
