import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param grid: a 2D array
     * @return: the maximum area of an island in the given 2D array
     */
    public int maxAreaOfIsland(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(index(i, j, grid))) {
                    res = Math.max(res, dfs(i, j, grid, visited));
                }
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] grid, Set<Integer> visited) {
        int area = 1;
        visited.add(index(x, y, grid));
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1 && !visited.contains(index(nextX, nextY, grid))) {
                area += dfs(nextX, nextY, grid, visited);
            }
        }
        
        return area;
    }
    
    private int index(int x, int y, int[][] grid) {
        return x * grid[0].length + y;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
