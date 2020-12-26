public class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j, dirs));
                }
            }
        }
    
        return res;
    }
    
    private int dfs(int[][] grid, int x, int y, int[][] dirs) {
        int area = 1;
        grid[x][y] = -1;
    
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (0 <= newX && newX < grid.length && 0 <= newY && newY < grid[0].length && grid[newX][newY] == 1) {
                area += dfs(grid, newX, newY, dirs);
            }
        }
        
        return area;
    }
}
