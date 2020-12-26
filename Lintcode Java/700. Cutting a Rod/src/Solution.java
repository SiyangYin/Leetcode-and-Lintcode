public class Solution {
    /**
     * @param prices: the prices
     * @param n: the length of rod
     * @return: the max value
     */
    public int cutting(int[] prices, int n) {
        // Write your code here
        int[] dp = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i - 1];
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().cutting(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8));
    }
}
