public class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Math.max(preSum[r + 1] - preSum[l + 1] - dp[l + 1][r], preSum[r] - preSum[l] - dp[l][r - 1]);
            }
        }
        
        return dp[0][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }
}
