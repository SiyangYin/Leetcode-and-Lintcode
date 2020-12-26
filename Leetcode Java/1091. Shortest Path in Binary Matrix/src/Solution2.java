import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        boolean[][] visited = new boolean[n][n];
        int[][] dis = new int[n][n];
        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0][0] = true;
        dis[0][0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curx = cur / n, cury = cur % n;
            for (int i = 0; i < 8; i++) {
                int nextx = curx + dirs[i][0];
                int nexty = cury + dirs[i][1];
                if (inBound(nextx, nexty, n) && !visited[nextx][nexty] && grid[nextx][nexty] == 0) {
                    queue.offer(nextx * n + nexty);
                    visited[nextx][nexty] = true;
                    dis[nextx][nexty] = dis[curx][cury] + 1;
                    
                    if (nextx == n - 1 && nexty == n - 1) {
                        return dis[nextx][nexty];
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
