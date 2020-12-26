public class Solution {
    /**
     * @param cost:        costs of all cards
     * @param damage:      damage of all cards
     * @param totalMoney:  total of money
     * @param totalDamage: the damage you need to inflict
     * @return: Determine if you can win the game
     */
    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        // Write your code here
        int[][] dp = new int[cost.length][totalMoney + 1];
        for (int i = 0; i <= totalMoney; i++) {
            if (i >= cost[0]) {
                dp[0][i] = damage[0];
            }
        }
        
        for (int i = 1; i < cost.length; i++) {
            for (int j = 0; j <= totalMoney; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i]] + damage[i]);
                }
                
                if (dp[i][j] >= totalDamage) {
                    System.out.println(i + "  " + j);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] c = {1, 2, 3, 4, 5}, d = {1, 2, 3, 4, 5};
        int mon = 10, dam = 10;
        System.out.println(new Solution().cardGame(c, d, mon, dam));
    }
}
