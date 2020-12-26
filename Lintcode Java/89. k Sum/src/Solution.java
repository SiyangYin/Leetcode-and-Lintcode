public class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        for (int i = 0; i < A.length + 1; i++) {
            dp[i][0][0] = 1;
        }
    
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= target; l++) {
                    if (i < j) {
                        continue;
                    }
                    
                    if (i > 0) {
                        dp[i][j][l] = dp[i - 1][j][l];
                    }
                    if (i > 0 && j > 0 && l >= A[i - 1]) {
                        dp[i][j][l] += dp[i - 1][j - 1][l - A[i - 1]];
                    }
                }
            }
        }
        
        return dp[A.length][k][target];
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        System.out.println(new Solution().kSum(A, k, target));
    }
}
