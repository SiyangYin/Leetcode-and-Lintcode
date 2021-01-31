public class Solution2 {
    public int minDifficulty(int[] A, int d) {
        int n = A.length;
        if (n < d) {
            return -1;
        }
    
        int[][] dp = new int[2][n];
        for (int i = n - 1, curMax = 0; i >= 0; i--) {
            curMax = Math.max(curMax, A[i]);
            dp[1][i] = curMax;
        }
    
        for (int i = 2; i <= d; i++) {
        
        }
    }
}
