public class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //  不是浮盈浮亏
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
            
//            System.out.println("cash: " + sell + "\thold: " + buy);
        }
        
        return sell;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{2, 3, 2, 8, 9, 9}, 2));
        System.out.println(new Solution().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
