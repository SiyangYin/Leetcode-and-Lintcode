public class Solution2 {
    /**
     * @param K:      An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int K, int[] prices) {
        // write your code here
        int len = prices.length;
        if (K >= len / 2) {
            int res = 0;
            for (int i = 1; i < len; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            
            return res;
        }
        
        // f[i][j]  已经进行过i次买入，第j天手里有股
        // g[i][j]  已经进行过i次买入，第j天手里无股
        int[][] f = new int[2][len], g = new int[2][len];
        f[0][0] = Integer.MIN_VALUE / 2;
        f[1][0] = -prices[0];
        g[0][0] = 0;
        g[1][0] = Integer.MIN_VALUE / 2;
        
        int res = 0;
        for (int i = 0; i <= K; i++) {
            for (int j = 1; j < len; j++) {
                f[i & 1][j] = f[i & 1][j - 1];
                if (i >= 1) {
                    f[i & 1][j] = Math.max(f[i & 1][j], g[i - 1 & 1][j - 1] - prices[j]);
                }
                g[i & 1][j] = Math.max(g[i & 1][j - 1], f[i & 1][j - 1] + prices[j]);
                
                if (j == len - 1) {
                    res = Math.max(res, f[i & 1][j]);
                    res = Math.max(res, g[i & 1][j]);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(2, new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
        System.out.println(new Solution().maxProfit(1, new int[]{3, 4, 8, 5}));
        System.out.println(new Solution().maxProfit(9, new int[]{12,3,7,4,5,13,2,8,4,7,6,5,7}));
        System.out.println(new Solution().maxProfit(5, new int[]{0,3,8,6,8,6,6,8,2,0,2,7}));
        System.out.println(new Solution2().maxProfit(2, new int[]{1, 3, 2, 1}));
    }
}
