public class Solution {
    public int closedIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i += Math.max(grid.length - 1, 1)) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, -1);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j += Math.max(grid[0].length - 1, 1)) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, -1);
                }
            }
        }
        
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, 2);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int x, int y, int[][] grid, int color) {
        grid[x][y] = color;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 0) {
                dfs(nextX, nextY, grid, color);
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
