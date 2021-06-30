import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param grid: An array.
     * @return: An integer.
     */
    public int maxDistance(int[][] grid) {
        // Write your code here.
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        
        if (queue.size() == m * n) {
            return -1;
        }
        
        int res = -1;
        int[] d = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size() - 1; i >= 0; i--) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + d[j], y = cur[1] + d[j + 1];
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 0 && !vis[x][y]) {
                        queue.offer(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        
        return res;
    }
}
