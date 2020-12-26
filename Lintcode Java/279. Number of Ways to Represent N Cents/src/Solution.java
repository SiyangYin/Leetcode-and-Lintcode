public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int waysNCents(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] coins = {1, 5, 10, 25};
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().waysNCents(11));
    }
}
