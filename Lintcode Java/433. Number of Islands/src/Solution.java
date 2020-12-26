import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
    
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j, d);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void markByBFS(boolean[][] grid, int x, int y, int[][] d) {
        grid[x][y] = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] adj = {cur[0] + d[i][0], cur[1] + d[i][1]};
                if (0 <= adj[0] && adj[0] < grid.length
                        && 0 <= adj[1] && adj[1] < grid[0].length && grid[adj[0]][adj[1]]) {
                    queue.offer(adj);
                    grid[adj[0]][adj[1]] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        boolean[][] grid = {{true, true, false, false, false},
                            {false, true, false, false, true}};
    
        System.out.println(new Solution().numIslands(grid));
    }
}

