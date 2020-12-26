import java.util.Arrays;

public class Solution {
    /**
     * @param n:           The number of cards
     * @param totalProfit: The totalProfit
     * @param totalCost:   The totalCost
     * @param a:           The profit of cards
     * @param b:           The cost of cards
     * @return: Return the number of legal plan
     */
    public int numOfPlan(int n, int totalProfit, int totalCost, int[] a, int[] b) {
        // Write your code here
        int MOD = (int) (1E9 + 7);
        // dp[i][j][k]是从前i + 1个物品里选，价值大于等于j的且成本恰好等于k的组合总数
        int[][][] dp = new int[n][totalProfit + 2][totalCost];
        
        dp[0][0][0] = 1;
        for (int i = 0; i <= Math.min(a[0], totalProfit + 1); i++) {
            dp[0][i][b[0]] += 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= totalProfit + 1; j++) {
                for (int k = 0; k < totalCost; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (k >= b[i]) {
                        dp[i][j][k] += dp[i - 1][Math.max(0, j - a[i])][k - b[i]];
                    }
                    
                    dp[i][j][k] %= MOD;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < totalCost; i++) {
            res += dp[n - 1][totalProfit + 1][i];
            res %= MOD;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numOfPlan(2, 3, 5, new int[]{2, 3}, new int[]{2, 2}));
        System.out.println(new Solution().numOfPlan(3, 5, 10, new int[]{6, 7, 8}, new int[]{2, 3, 5}));
        System.out.println(new Solution().numOfPlan(5, 3, 9, new int[]{48, 14, 71, 59, 91}, new int[]{1, 1, 0, 2, 2}));
        System.out.println(new Solution().numOfPlan(54, 6, 19, new int[]{50,52,15,60,58,45,82,76,48,84,84,68,28,10,2,87,31,36,23,95,3,25,68,91,34,67,21,29,6,78,96,62,92,43,95,37,42,23,99,22,10,33,16,16,0,96,42,32,51,24,44,55,81,86},
                new int[]{0,2,0,0,0,2,1,2,2,1,2,1,2,0,0,0,1,2,1,0,2,1,0,2,0,0,0,2,0,1,1,0,0,1,1,2,1,2,0,2,2,1,2,1,1,1,2,0,1,2,2,1,1,1}));
    }
}
