public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[A.length][m + 1];
        for (int i = 0; i * A[0] <= m; i++) {
            dp[0][i * A[0]] = i * V[0];
        }
    
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i]] + V[i]);
                }
            }
        }
        
        return dp[A.length - 1][m];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
    }
}
