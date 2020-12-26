public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 2) {
            return 0;
        }
        
        int[] dp = new int[2];
        int cur = 0;
        for (int i = 2; i <= cost.length; i++) {
            cur ^= 1;
            dp[cur] = Math.min(dp[cur ^ 1] + cost[i - 1], dp[cur] + cost[i - 2]);
        }
        
        return dp[cur];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
