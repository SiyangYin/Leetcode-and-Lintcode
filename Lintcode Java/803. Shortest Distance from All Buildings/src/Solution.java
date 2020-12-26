import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        int[][] totalDis = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(new int[]{i, j}, grid, totalDis);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.min(res, totalDis[i][j]);
                }
            }
        }
        
        return res;
    }
    
    private void bfs(int[] start, int[][] grid, int[][] totalDis) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        
        int[] d = {1, 0, -1, 0, 1};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                    if (inBound(nextX, nextY, grid) && grid[nextX][nextY] != 2 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        if (grid[nextX][nextY] == 0 && totalDis[nextX][nextY] != Integer.MAX_VALUE) {
                            totalDis[nextX][nextY] += step;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    totalDis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0}};
        System.out.println(new Solution().shortestDistance(g));
    }
}
