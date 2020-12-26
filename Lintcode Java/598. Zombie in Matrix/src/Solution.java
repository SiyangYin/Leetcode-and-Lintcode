import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int pCount = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 0) {
                    pCount++;
                }
            }
        }
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + dirs[j][0];
                    int y = cur[1] + dirs[j][1];
                    if (inBound(grid, x, y) && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        pCount--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            
            if (!queue.isEmpty()) {
                step++;
            }
        }
        
        return pCount == 0 ? step : -1;
    }
    
    private boolean inBound(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 0, 0},
                {1, 0, 0, 2, 1},
                {0, 1, 0, 0, 0}};
        System.out.println(new Solution().zombie(grid));
    }
}
