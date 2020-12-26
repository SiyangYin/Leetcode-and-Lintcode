import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int[] start = findOne(grid);
        int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        Map<int[], Integer> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{start[0], start[1]});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;
            int count = 0;
            
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + d[i][0];
                int y = cur[1] + d[i][1];
                if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1) {
                    count++;
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            
            map.put(cur, count);
        }
        
        int res = 0;
        
        for (Integer neighbor : map.values()) {
            res += 4 - neighbor;
        }
        
        return res;
    }
    
    private int[] findOne(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        // int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid = {{1, 1}, {1, 1}};
        System.out.println(new Solution().islandPerimeter(grid));
    }
}
