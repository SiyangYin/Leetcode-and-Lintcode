public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int[][] up = new int[m][n], down = new int[m][n], left = new int[m][n], right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1;
                    }
                    
                    if (i > 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }
            }
        }
    
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1;
                    }
                    
                    if (i < m - 1) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }
    
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        left[i][j] = 1;
                    }
                    
                    if (j > 0) {
                        left[i][j] += left[i][j - 1];
                    }
                }
            }
        }
    
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        right[i][j] = 1;
                    }
                    
                    if (j < n - 1) {
                        right[i][j] += right[i][j + 1];
                    }
                }
            }
        }
        
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W' || grid[i][j] == 'E') {
                    continue;
                }
                
                res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
            }
        }
        
        return res;
    }
}
