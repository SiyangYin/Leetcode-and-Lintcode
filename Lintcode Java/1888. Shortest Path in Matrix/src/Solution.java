import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param grid: the input matrix
     * @return: the new matrix
     */
    public int[][] shortestPath(int[][] grid) {
        // Write your code here
        int m = grid.length, n = grid[0].length;
        int[][] steps = new int[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
    
        int step = 0;
        int[] d = {1, 0, -1, 0, 1}, mark = {2, 5, 3, 4};
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                    if (inBound(nextX, nextY, grid)) {
                        if (grid[nextX][nextY] == 0) {
                            grid[nextX][nextY] = mark[j];
                            steps[nextX][nextY] = step;
                            
                            queue.offer(new int[]{nextX, nextY});
                        } else {
                            if (steps[nextX][nextY] == step) {
                                grid[nextX][nextY] = Math.min(grid[nextX][nextY], mark[j]);
                            }
                        }
                    }
                }
            }
        }
        
        return grid;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 0, 1}, {0,0,0},{1,0,0}};
        System.out.println(Arrays.deepToString(new Solution().shortestPath(g)));
    }
}
