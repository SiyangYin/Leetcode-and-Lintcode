import java.util.Arrays;

public class Solution {
    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == -1) {
            return 0;
        }
        
        int n = grid.length;
        int[][][] dp = new int[2 * n - 1][n][n];
    
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        dp[0][0][0] = grid[0][0];
    
        for (int k = 1; k < 2 * n - 1; k++) {
            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    
                    int j1 = k - i1, j2 = k - i2;
                    
                    if (j1 >= 0 && j1 < n && j2 >= 0 && j2 < n) {
                        if (grid[i1][j1] == -1 || grid[i2][j2] == -1) {
                            dp[k][i1][i2] = -1;
                            continue;
                        }
    
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2]);
    
                        if (i1 > 0) {
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2]);
                        }
    
                        if (i2 > 0) {
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1]);
                        }
    
                        if (i1 > 0 && i2 > 0) {
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1]);
                        }
    
                        if (dp[k][i1][i2] == -1) {
                            continue;
                        }
                        
                        dp[k][i1][i2] += grid[i1][j1];
                        if (i1 != i2) {
                            dp[k][i1][i2] += grid[i2][j2];
                        }
                    }
                }
            }
            
        }
    
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.println("k = " + i);
            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(dp[i][j]));;
            }
        }
        
        return dp[2 * n - 2][n - 1][n - 1] == -1 ? 0 : dp[2 * n - 2][n - 1][n - 1];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 1, -1},
                        {1, -1, 1},
                        {-1, 1, 1}};
        System.out.println(new Solution().cherryPickup(grid));
    
    }
}
