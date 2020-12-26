public class Solution2 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[A.length][A.length];
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
    
        for (int len = 2; len <= A.length; len++) {
            for (int i = 0; i + len - 1 < A.length; i++) {
                int left = i, right = i + len - 1;
                dp[left][right] = Integer.MAX_VALUE;
                for (int j = left; j < right; j++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][j] + dp[j + 1][right] + prefixSum[right + 1] - prefixSum[left]);
                }
            }
        }
        
        return dp[0][A.length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().stoneGame(new int[]{3, 4, 3}));
        System.out.println(new Solution2().stoneGame(new int[]{3}));
    }
}
