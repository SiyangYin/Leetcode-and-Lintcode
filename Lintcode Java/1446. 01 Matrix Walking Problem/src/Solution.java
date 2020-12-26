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
     * @param grid: The gird
     * @return: Return the steps you need at least
     */
    public int getBestRoad(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int[][] disFromStart = new int[m][n], disFromEnd = new int[m][n];
        for (int i = 0; i < disFromStart.length; i++) {
            Arrays.fill(disFromStart[i], Integer.MAX_VALUE);
            Arrays.fill(disFromEnd[i], Integer.MAX_VALUE);
        }
        
        
        bfs(new Pair(0, 0), disFromStart, grid);
        bfs(new Pair(m - 1, n - 1), disFromEnd, grid);
    
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (disFromStart[i][j] < Integer.MAX_VALUE && disFromEnd[i][j] < Integer.MAX_VALUE) {
                    res = Math.min(res, disFromStart[i][j] + disFromEnd[i][j]);
                }
            }
        }
        
        return res < Integer.MAX_VALUE ? res : -1;
    }
    
    private void bfs(Pair start, int[][] dis, int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
    
        dis[start.x][start.y] = 0;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (Pair next : getNexts(cur, grid, visited)) {
                    int x = next.x, y = next.y;
                    dis[x][y] = step;
                    visited.add(next);
                    if (grid[x][y] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
    }
    
    private List<Pair> getNexts(Pair cur, int[][] grid, Set<Pair> visited) {
        List<Pair> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
            if (inBound(nextX, nextY, grid)) {
                Pair next = new Pair(nextX, nextY);
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 1, 1, 1}};
        System.out.println(new Solution().getBestRoad(g));
    }
}
