public class Solution {
    /**
     * @param prices: a list of integers
     * @param fee:    a integer
     * @return: return a integer
     */
    public int maxProfit(int[] prices, int fee) {
        // write your code here
        int len = prices.length;
        int[] buy = new int[2], sell = new int[2];
        buy[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            buy[i & 1] = Math.max(buy[i - 1 & 1], sell[i - 1 & 1] - prices[i]);
            sell[i & 1] = Math.max(sell[i - 1 & 1], buy[i - 1 & 1] + prices[i] - fee);
        }
        
        return sell[len - 1 & 1];
    }
}
