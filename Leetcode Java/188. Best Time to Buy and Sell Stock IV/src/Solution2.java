import java.util.Arrays;

public class Solution2 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        if (k >= len / 2) {
            int res = 0;
            for (int i = 1; i < len; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            
            return res;
        }
        
        int[][] buy = new int[2][k + 1], sell = new int[2][k + 1];
        Arrays.fill(buy[0], -prices[0]);
        buy[0][0] = Integer.MIN_VALUE;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= k; j++) {
                buy[i & 1][j] = buy[i - 1 & 1][j];
                if (j > 0) {
                    buy[i & 1][j] = Math.max(buy[i & 1][j], sell[i - 1 & 1][j - 1] - prices[i]);
                }
                
                sell[i & 1][j] = Math.max(sell[i - 1 & 1][j], buy[i - 1 & 1][j] + prices[i]);
            }
        }
        
        return sell[len - 1 & 1][k];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new Solution2().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new Solution2().maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
