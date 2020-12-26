import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        if (queue.isEmpty() || queue.size() == grid.length * grid[0].length) {
            return -1;
        }
        
        int res = -1;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] next : getNexts(x, y, grid)) {
                    queue.offer(next);
                    grid[next[0]][next[1]] = 1;
                }
            }
        }
        
        return res;
    }
    
    private List<int[]> getNexts(int x, int y, int[][] grid) {
        List<int[]> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 0) {
                nexts.add(new int[]{nextX, nextY});
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new Solution().maxDistance(grid));
    }
}
