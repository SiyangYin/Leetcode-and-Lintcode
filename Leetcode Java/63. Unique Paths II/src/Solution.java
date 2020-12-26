public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
    
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }
    
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j >= 1) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]
                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
