import java.util.Arrays;

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[][] buy = new int[2][3], sell = new int[2][3];
        Arrays.fill(buy[0], -prices[0]);
        buy[0][0] = Integer.MIN_VALUE;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 2; j++) {
                buy[i & 1][j] = buy[i - 1 & 1][j];
                if (j > 0) {
                    buy[i & 1][j] = Math.max(buy[i & 1][j], sell[i - 1 & 1][j - 1] - prices[i]);
                }
                
                sell[i & 1][j] = Math.max(sell[i - 1 & 1][j], buy[i - 1 & 1][j] + prices[i]);
            }
        }
    
        // System.out.println(Arrays.deepToString(sell));
        return sell[len - 1 & 1][2];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
    }
}
