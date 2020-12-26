public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            profit += Math.max(0, prices[i + 1] - prices[i]);
        }
        
        return profit;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
