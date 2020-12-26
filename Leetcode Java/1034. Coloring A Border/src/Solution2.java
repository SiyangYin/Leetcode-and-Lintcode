import java.util.Arrays;

public class Solution2 {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, visited, r0, c0, grid[r0][c0], new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}});
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int x, int y, int originalColor, int[][] dirs) {
        visited[x][y] = true;
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) {
            grid[x][y] = -1;
        }
    
        for (int i = 0; i < 4; i++) {
            int X = x + dirs[i][0];
            int Y = y + dirs[i][1];
            if (inBound(grid, X, Y)) {
                if (checkColor(grid, X, Y, originalColor)) {
                    grid[x][y] = -1;
                }
                if (!visited[X][Y] && grid[X][Y] == originalColor) {
                    dfs(grid, visited, X, Y, originalColor, dirs);
                }
            }
        }
    }
    
    private boolean inBound(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    private boolean checkColor(int[][] grid, int x, int y, int originalColor) {
        if (grid[x][y] != originalColor && grid[x][y] != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(new Solution2().colorBorder(grid, 1, 1, 2)));
    
    }
}
