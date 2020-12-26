public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int res = 0, curMin = Integer.MAX_VALUE;
    
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            res = Math.max(res, prices[i] - curMin);
        }
        
        return res;
    }
}
