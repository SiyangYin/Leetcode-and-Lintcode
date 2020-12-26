public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j, visited, d);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited, int[][] d) {
        visited[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                    && !visited[x][y]
                    && grid[x][y] == '1') {
                dfs(grid, x, y, visited, d);
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
    
        System.out.println(new Solution().numIslands(grid));
    }
}
