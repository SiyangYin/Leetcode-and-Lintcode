import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (grid.length <= 1 && grid[0].length <= 1) {
            return 0;
        }
        
        int[] start = {0, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        visited[0][0][0] = true;
        
        int[] d = {1, 0, -1, 0, 1};
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                    if (inBound(nextX, nextY, grid)) {
                        int obs = cur[2] + grid[nextX][nextY];
                        int[] next = {nextX, nextY, obs};
                        if (obs <= k && !visited[nextX][nextY][obs]) {
                            if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                                return res;
                            }
                            
                            queue.offer(next);
                            visited[nextX][nextY][obs] = true;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
