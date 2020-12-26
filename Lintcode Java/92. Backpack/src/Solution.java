public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[A.length][m + 1];
        for (int j = A[0]; j <= m; j++) {
            dp[0][j] = A[0];
        }
    
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i]] + A[i]);
                }
            }
        }
        
        return dp[A.length - 1][m];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().backPack(10, new int[]{3, 4, 8, 5}));
    }
}
