public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 1, min = prices[0]; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        int res = 0;
        for (int i = n - 1, max = 0; i >= 0; i--) {
            res = Math.max(res, max - prices[i] + dp[i]);
            max = Math.max(max, prices[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3}));
    }
}
