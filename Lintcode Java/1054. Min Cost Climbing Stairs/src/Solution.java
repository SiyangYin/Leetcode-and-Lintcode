public class Solution {
    /**
     * @param cost: an array
     * @return: minimum cost to reach the top of the floor
     */
    public int minCostClimbingStairs(int[] cost) {
        // Write your code here
        if (cost == null || cost.length == 0) {
            return 0;
        }
        
        int len = cost.length;
        if (len == 1 || len == 2) {
            return cost[len - 1];
        }
        
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < len; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        return Math.min(dp[len - 1], dp[len - 2]);
    }
    
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }
}
