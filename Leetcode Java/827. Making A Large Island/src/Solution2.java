import java.util.*;

public class Solution2 {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ids = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, id = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    map.put(id, bfs(i, j, id, ids, grid, visited));
                    id++;
                }
            }
        }
    
        int res = 0;
        boolean found = false;
        int[] d = {1, 0, -1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    found = true;
                    
                    int area = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + d[k], nextJ = j + d[k + 1];
                        if (inBound(nextI, nextJ, grid) && grid[nextI][nextJ] == 1) {
                            int id = ids[nextI][nextJ];
                            if (!set.contains(id)) {
                                area += map.get(id);
                                set.add(id);
                            }
                        }
                    }
                
                    res = Math.max(res, area);
                }
            }
        }
        
        return found ? res : m * n;
    }
    
    private int bfs(int x, int y, int id, int[][] ids, int[][] grid, boolean[][] visited) {
        visited[x][y] = true;
        ids[x][y] = id;
        
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        int[] d = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            area++;
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + d[i], nextY = cur[1] + d[i + 1];
                if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    ids[nextX][nextY] = id;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        
        return area;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
