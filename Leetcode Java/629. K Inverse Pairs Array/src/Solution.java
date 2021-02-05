public class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = (int) (1E9 + 7);
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        
        for (int i = 2; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += dp[i - 1][j];
                if (j >= i) {
                    sum -= dp[i - 1][j - i];
                }
                dp[i][j] = (int) (sum % MOD);
            }
        }
        
        return (dp[n][k] + MOD) % MOD;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kInversePairs(3, 1));
    }
}
