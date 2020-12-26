public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
    
        int n = grid.length, m = grid[0].length;
        
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        
        return grid[n - 1][m - 1];
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{1, 3, 1},
                                    new int[]{1, 5, 1},
                                    new int[]{4, 2, 1},};
        
        System.out.println(new Solution().minPathSum(grid));
        
    }
}
