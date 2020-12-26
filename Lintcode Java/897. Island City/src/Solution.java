public class Solution {
    /**
     * @param grid: an integer matrix
     * @return: an integer
     */
    public int numIslandCities(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1 && dfs(i, j, grid)) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private boolean dfs(int x, int y, int[][] grid) {
        boolean hasCity = false;
        if (grid[x][y] == 2) {
            hasCity = true;
        }
        
        grid[x][y] = -1;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (isValid(nextX, nextY, grid)) {
                hasCity |= dfs(nextX, nextY, grid);
            }
        }
        
        return hasCity;
    }
    
    private boolean isValid(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && (grid[x][y] == 1 || grid[x][y] == 2);
    }
}
