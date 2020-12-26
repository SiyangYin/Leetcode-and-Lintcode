import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int m = grid.length, n = grid[0].length;
        int good = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    good++;
                }
            }
        }
        
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        boolean rotting = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            rotting = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + d[j][0];
                    int newY = cur[1] + d[j][1];
                    if (0 <= newX && newX < m && 0 <= newY && newY < n && grid[newX][newY] == 1) {
                        queue.offer(new int[]{newX, newY});
                        grid[newX][newY] = 2;
                        good--;
                        rotting = true;
                    }
                }
            }
            if (rotting) {
                res++;
            }
            
            if (good == 0) {
                break;
            }
        }
        
        return good == 0 ? res : -1;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new Solution().orangesRotting(grid));
    }
    
}
