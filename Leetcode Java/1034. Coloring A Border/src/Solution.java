import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        int originalColor = grid[r0][c0];
        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        if (inBound(grid, r0, c0) && isBoarder(grid, r0, c0, originalColor, dirs)) {
            grid[r0][c0] = -1;
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dirs[i][0];
                int newY = cur[1] + dirs[i][1];
                if (inBound(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == originalColor) {
                    if (isBoarder(grid, newX, newY, originalColor, dirs)) {
                        grid[newX][newY] = -1;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
    
    private boolean inBound(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    private boolean isBoarder(int[][] grid, int x, int y, int originalColor, int[][] dirs) {
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) {
            return true;
        }
    
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (inBound(grid, newX, newY) && grid[newX][newY] != originalColor && grid[newX][newY] > 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(new Solution().colorBorder(grid, 1, 1, 2)));
    
    }
}
