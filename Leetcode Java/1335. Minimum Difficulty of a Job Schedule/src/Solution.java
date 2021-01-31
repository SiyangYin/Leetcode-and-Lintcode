import java.util.Arrays;

public class Solution {
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
            Arrays.fill(dp[i & 1], 1 << 30);
            for (int j = 0; j <= n - i; j++) {
                int curMax = 0;
                for (int k = j; k <= n - i; k++) {
                    curMax = Math.max(curMax, A[k]);
                    dp[i & 1][j] = Math.min(dp[i & 1][j], dp[i - 1 & 1][k + 1] + curMax);
                }
            }
        }
        
        return dp[d & 1][0];
    }
    
    public static void main(String[] args) {
        int[] A = {6, 5, 4, 3, 2, 1};
        System.out.println(new Solution().minDifficulty(A, 2));
        
        System.out.println(Integer.MIN_VALUE);
        System.out.println(1 << 30);
    }
}
