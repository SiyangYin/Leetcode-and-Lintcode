import java.util.Arrays;

public class Solution {
    /**
     * @param grid: a grid
     * @return: given the grids,return plateau.
     */
    public int[][] getPlateau(int[][] grid) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[] d = {1, 0, -1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 1) {
                    continue;
                }
                
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 4; k++) {
                    int nextX = i + d[k], nextY = j + d[k + 1];
                    if (inBound(nextX, nextY, grid)) {
                        max = Math.max(max, grid[nextX][nextY]);
                    }
                }
                
                if (grid[i][j] >= max) {
                    res[i][j] = 2;
                } else {
                    dfs(i, j, 1, grid, res, visited);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j]--;
            }
        }
        
        return res;
    }
    
    private void dfs(int x, int y, int val, int[][] grid, int[][] res, boolean[][] visited) {
        visited[x][y] = true;
        res[x][y] = val;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && !visited[nextX][nextY] && grid[nextX][nextY] == grid[x][y]) {
                dfs(nextX, nextY, val, grid, res, visited);
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {81, 1, 4, 95, 9, 30},
                {95, 5, 6, 65, 6, 64},
                {100, 81, 88, 24, 21, 29},
                {89, 93, 9, 70, 39, 11},
                {40, 1, 70, 13, 5, 57},
                {21, 77, 79, 51, 45, 21},
                {98, 57, 3, 49, 45, 74},
                {40, 51, 17, 5, 17, 1},
                {30, 51, 16, 25, 72, 29},
                {33, 1, 77, 61, 21, 57}};
        
        int[][] plateau = new Solution().getPlateau(grid);
        for (int i = 0; i < plateau.length; i++) {
            System.out.println(Arrays.toString(plateau[i]));
        }
    }
}
