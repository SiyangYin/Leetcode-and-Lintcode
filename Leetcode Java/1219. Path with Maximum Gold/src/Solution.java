public class Solution {
    public int getMaximumGold(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                
                res = Math.max(res, dfs(i, j, grid, new boolean[m][n], d));
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] grid, boolean[][] visited, int[] d) {
        int sum = 0;
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                sum = Math.max(sum, dfs(nextX, nextY, grid, visited, d));
            }
        }
        
        visited[x][y] = false;
        return sum + grid[x][y];
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
