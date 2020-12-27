import java.util.*;

public class Solution {
    /**
     * @param grid:
     * @return: nothing
     */
    public int largestIsland(int[][] grid) {
        // Write your code here
        int res = 0, label = 2;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    map.put(label, bfs(i, j, grid, label, visited, d));
                    res = Math.max(res, map.get(label));
                    label++;
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + d[k], nextY = j + d[k + 1];
                        if (inBound(nextX, nextY, grid) && map.containsKey(grid[nextX][nextY])) {
                            set.add(grid[nextX][nextY]);
                        }
                    }
                    
                    int area = 1;
                    for (int e : set) {
                        area += map.get(e);
                    }
                    res = Math.max(res, area);
                }
            }
        }
        
        return res;
    }
    
    private int bfs(int x, int y, int[][] grid, int label, boolean[][] visited, int[] d) {
        visited[x][y] = true;
        grid[x][y] = label;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        int area = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + d[i], nextY = cur[1] + d[i + 1];
                if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    grid[nextX][nextY] = label;
                    area++;
                }
            }
        }
        
        return area;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 1}, {1, 1}};
        System.out.println(new Solution().largestIsland(g));
    }
}
