public class Solution {
    /**
     * @param stones:
     * @param K:
     * @return: return a integer
     */
    public int mergeStones(int[] stones, int K) {
        // write your code here
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        
        int[][] dp = new int[n][n];
        for (int len = K; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE / 2;
                for (int i = l; i < r; i += K - 1) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r]);
                }
                
                if ((len - 1) % (K - 1) == 0) {
                    dp[l][r] += preSum[r + 1] - preSum[l];
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mergeStones(new int[]{3, 2, 4, 1}, 2));
    }
}
