public class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - prices[i - 1] - fee);
            dp[i][1] = Math.max(dp[i - 1][1] + prices[i] - prices[i - 1], dp[i - 1][0]);
        }
        
        return Math.max(dp[len - 1][0], dp[len - 1][1] - fee);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(new Solution2().maxProfit(new int[]{1, 4, 6, 2, 8, 3, 10, 14}, 3));
    }
}
