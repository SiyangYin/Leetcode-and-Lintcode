public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        return res;
    }
}
