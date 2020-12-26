import java.util.Arrays;

public class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) {
            return 0;
        }
        
        int[][] dp = new int[2][target + 1];
        for (int i = 1; i <= Math.min(f, target); i++) {
            dp[0][i] = 1;
        }
        
        int MOD = (int) (1E9 + 7);
        for (int i = 1; i < d; i++) {
            Arrays.fill(dp[i & 1], 0);
            for (int j = i + 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j > k) {
                        dp[i & 1][j] += dp[i - 1 & 1][j - k];
                        dp[i & 1][j] %= MOD;
                    }
                }
            }
        }
        
        return dp[d - 1 & 1][target];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numRollsToTarget(2, 6, 7));
        System.out.println(new Solution().numRollsToTarget(2, 5, 10));
    }
}
