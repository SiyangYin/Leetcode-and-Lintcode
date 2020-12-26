import java.util.*;

public class Solution {
    
    class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    
    // 过不了
    public int shortestDistance(int[][] grid) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        int[][] dis = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid, dis);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.min(res, dis[i][j]);
                }
            }
        }
        
        return res;
    }
    
    private void bfs(int x, int y, int[][] grid, int[][] dis) {
        Pair start = new Pair(x, y);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(start);
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        int[] d = {1, 0, -1, 0, 1};
        
        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                dis[cur.x][cur.y] += step;
                for (int j = 0; j < 4; j++) {
                    int nextX = cur.x + d[j], nextY = cur.y + d[j + 1];
                    if (inBound(nextX, nextY, grid)) {
                        Pair next = new Pair(nextX, nextY);
                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(new Solution().shortestDistance(g));
    }
}