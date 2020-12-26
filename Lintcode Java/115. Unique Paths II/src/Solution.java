public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        }
    
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[dp.length - 1];
    }
    
    public static void main(String[] args) {
        int[][] obstacles = new int[3][];
        obstacles[0] = new int[]{0, 0, 0};
        obstacles[1] = new int[]{0, 1, 0};
        obstacles[2] = new int[]{0, 0, 0};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacles));
    }
}