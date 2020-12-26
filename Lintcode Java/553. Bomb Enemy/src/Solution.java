public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        int[][][] dp = new int[m][n][4];
        
        // 上
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    dp[i][j][0] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        dp[i][j][0] = 1;
                    }
                    if (i > 0) {
                        dp[i][j][0] += dp[i - 1][j][0];
                    }
                }
            }
        }
        
        // 下
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    dp[i][j][1] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        dp[i][j][1] = 1;
                    }
                    if (i < m - 1) {
                        dp[i][j][1] += dp[i + 1][j][1];
                    }
                }
            }
        }
        
        // 左
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') {
                    dp[i][j][2] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        dp[i][j][2] = 1;
                    }
                    if (j > 0) {
                        dp[i][j][2] += dp[i][j - 1][2];
                    }
                }
            }
        }
    
        // 右
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') {
                    dp[i][j][3] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        dp[i][j][3] = 1;
                    }
                    if (j < n - 1) {
                        dp[i][j][3] += dp[i][j + 1][3];
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E' || grid[i][j] == 'W') {
                    continue;
                }
                
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += dp[i][j][k];
                }
                
                res = Math.max(res, sum);
            }
        }
        
        return res;
    }
}
