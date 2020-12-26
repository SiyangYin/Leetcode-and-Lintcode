public class Solution2 {
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
    
        int[] dp = new int[m + 1];
        for (int j = A[0]; j <= m; j++) {
            dp[j] = A[0];
        }
    
        for (int i = 1; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
    
        return dp[m];
    }
}
