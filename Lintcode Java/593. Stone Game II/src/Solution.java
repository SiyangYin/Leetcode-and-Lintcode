public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        int[] B = new int[n * 2 - 1];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i % n];
        }
        
        A = B;
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        int[][] dp = new int[A.length][A.length];
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < A.length; i++) {
                int l = i, r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + preSum[r + 1] - preSum[l]);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int l = 0; l + n - 1 < A.length; l++) {
            res = Math.min(res, dp[l][l + n - 1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stoneGame2(new int[]{1, 1, 4, 4}));
        System.out.println(new Solution().stoneGame2(new int[]{333}));
    }
}
