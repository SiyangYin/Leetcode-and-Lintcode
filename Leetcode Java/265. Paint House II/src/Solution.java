public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        // n number of houses, m number of colors
        int n = costs.length, m = costs[0].length;
        int[][] dp = new int[2][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = costs[0][i];
        }
        
        int curIdx = 1;
        for (int i = 1; i < n; i++) {
            int minCost1 = Integer.MAX_VALUE, minIdx1 = 0;
            int minCost2 = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (dp[curIdx ^ 1][j] < minCost1) {
                    minCost2 = minCost1;
                    minCost1 = dp[curIdx ^ 1][j];
                    minIdx1 = j;
                } else if (dp[curIdx ^ 1][j] < minCost2) {
                    minCost2 = dp[curIdx ^ 1][j];
                }
            }
            
            for (int j = 0; j < m; j++) {
                if (j == minIdx1) {
                    dp[curIdx][j] = minCost2 + costs[i][j];
                } else {
                    dp[curIdx][j] = minCost1 + costs[i][j];
                }
            }
            
            curIdx ^= 1;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[curIdx ^ 1][i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        System.out.println(new Solution().minCostII(costs));
    }
}
