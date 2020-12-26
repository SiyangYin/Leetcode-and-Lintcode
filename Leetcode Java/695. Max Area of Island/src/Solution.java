import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j, dirs));
                }
            }
        }
        
        return res;
    }
    
    private int bfs(int[][] grid, int x, int y, int[][] dirs) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = -1;
        
        int area = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dirs[i][0];
                int newY = cur[1] + dirs[i][1];
                if (0 <= newX && newX < grid.length && 0 <= newY && newY < grid[0].length && grid[newX][newY] == 1) {
                    queue.offer(new int[]{newX, newY});
                    area++;
                    grid[newX][newY] = -1;
                }
            }
        }
        
        return area;
    }
}
