public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[] buy = new int[len], sell = new int[len], cool = new int[len];
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1] + prices[i] - prices[i - 1], cool[i - 1]);
            sell[i] = buy[i - 1] + prices[i] - prices[i - 1];
            cool[i] = Math.max(cool[i - 1], sell[i - 1]);
        }
        
        return Math.max(Math.max(sell[len - 1], cool[len - 1]), buy[len - 1] - prices[len - 1]);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
