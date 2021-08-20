

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        
        buy[0] = -prices[0];
        sell[0] = 0;
    
        for (int i = 1; i < len; i++) {
            //  不是浮盈浮亏，此处数组里表示的是手上的cash数目
            //  buy[i]  在日期0，1，。。。，i中，以buy为结尾可能获得的最大利润
            //  sell[i]  在日期0，1，。。。，i中，以sell为结尾可能获得的最大利润
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        
        return sell[len - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
