import java.util.Arrays;

public class Solution3 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        
        // System.out.println(Arrays.deepToString(dp));
        System.out.println(Arrays.toString(dp[len - 1]));
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        // System.out.println(new Solution2().maxProfit(new int[]{2, 3, 2, 8, 9, 9}, 2));
        //
        // System.out.println(new Solution3().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        // System.out.println(new Solution3().maxProfit(new int[]{2, 3, 2, 8, 9, 9}, 2));
        // System.out.println(new Solution3().maxProfit(new int[]{1, 4}, 2));
        System.out.println(new Solution3().maxProfit(new int[]{1, 100}, 2));
        System.out.println(new Solution3().maxProfit(new int[]{1, 2}, 2));
        // System.out.println(new Solution2().maxProfit(new int[]{1, 4}, 2));
        // System.out.println(new Solution().maxProfit(new int[]{1, 4}, 2));
    }
}
