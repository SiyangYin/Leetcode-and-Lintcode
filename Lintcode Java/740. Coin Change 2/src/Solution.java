import java.util.Arrays;

public class Solution {
    /**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        // write your code here
        int[][] dp = new int[amount + 1][coins.length];
        Arrays.fill(dp[0], 1);
    
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j][i] += dp[j - coins[i]][i];
                }
                if (i > 0) {
                    dp[j][i] += dp[j][i - 1];
                }
            }
        }
        
        return dp[amount][coins.length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().change(8, new int[]{2, 3, 8}));
    }
}
