public class Solution {
    /**
     * @param prices: a list of integers
     * @return: return a integer
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int n = prices.length;
        int[] buy = new int[n], sell = new int[n], cool = new int[n];
        
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            sell[i] = buy[i - 1] + prices[i];
            cool[i] = Math.max(sell[i - 1], cool[i - 1]);
        }
        
        return Math.max(sell[n - 1], cool[n - 1]);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new Solution().maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}
