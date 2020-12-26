public class Solution {
    /**
     * @param grid: a 2d boolean array
     * @param k: an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    res += dfs(i, j, grid, dirs) >= k ? 1 : 0;
                }
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, boolean[][] grid, int[][] dirs) {
        int size = 1;
        grid[x][y] = false;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (isValid(nextX, nextY, grid)) {
                size += dfs(nextX, nextY, grid, dirs);
            }
        }
        
        return size;
    }
    
    private boolean isValid(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y];
    }
}
