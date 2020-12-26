public class Solution2 {
    /**
     * @param cost:        costs of all cards
     * @param damage:      damage of all cards
     * @param totalMoney:  total of money
     * @param totalDamage: the damage you need to inflict
     * @return: Determine if you can win the game
     */
    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        // Write your code here
        int[] dp = new int[totalMoney + 1];
        for (int i = 0; i <= totalMoney; i++) {
            if (i >= cost[0]) {
                dp[i] = damage[0];
            }
        }
        
        for (int i = 1; i < cost.length; i++) {
            for (int j = totalMoney; j >= 0; j--) {
                if (j >= cost[i]) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + damage[i]);
                }
                
                if (dp[j] >= totalDamage) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] c = {1, 2, 3, 4, 5}, d = {1, 2, 3, 4, 5};
        int mon = 10, dam = 10;
        System.out.println(new Solution2().cardGame(c, d, mon, dam));
    }
}
