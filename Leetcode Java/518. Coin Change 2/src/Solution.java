public class Solution {
    
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new Solution().change(amount, coins));
    }
    
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 0; j <= amount; j += coins[0]) {
            dp[0][j] = 1;
        }
    
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        
        return dp[coins.length - 1][amount];
    }
}
