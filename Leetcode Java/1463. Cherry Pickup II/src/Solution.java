import java.util.Arrays;

public class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][][] dp = new int[m][n][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        dp[0][0][n - 1] = n != 1 ? grid[0][0] + grid[0][n - 1] : grid[0][0];
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= Math.min(i, n - 1); j++) {
                for (int k = Math.max(0, n - i - 1); k <= n - 1; k++) {
                    
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int idx1 = j + d1, idx2 = k + d2;
                            
                            if (0 <= idx1 && idx1 < n && 0 <= idx2 && idx2 < n) {
                                if (dp[i - 1][idx1][idx2] != -1) {
                                    if (j == k) {
                                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][idx1][idx2] + grid[i][j]);
                                    } else {
                                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][idx1][idx2] + grid[i][j] + grid[i][k]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[m - 1][i][j]);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        int[][] grid = {
                {0, 8, 7, 10, 9, 10, 0, 9, 6},
                {8, 7, 10, 8, 7, 4, 9, 6, 10},
                {8, 1, 1, 5, 1, 5, 5, 1, 2},
                {9, 4, 10, 8, 8, 1, 9, 5, 0},
                {4, 3, 6, 10, 9, 2, 4, 8, 10},
                {7, 3, 2, 8, 3, 3, 5, 9, 8},
                {1, 2, 6, 5, 6, 2, 0, 10, 0}
        };
        
        System.out.println(new Solution().cherryPickup(grid));
    }
}
