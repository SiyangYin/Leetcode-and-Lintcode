import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] totalDis = new int[m][n];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid, totalDis);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && totalDis[i][j] != -1) {
                    res = Math.min(res, totalDis[i][j]);
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void bfs(int x, int y, int[][] grid, int[][] totalDis) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int[] d = {1, 0, -1, 0, 1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                    if (inBound(nextX, nextY, grid) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        if (totalDis[nextX][nextY] != -1) {
                            totalDis[nextX][nextY] += step;
                        }
                        
                        int[] next = {nextX, nextY};
                        queue.offer(next);
                    }
                }
            }
        }
    
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    totalDis[i][j] = -1;
                }
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
