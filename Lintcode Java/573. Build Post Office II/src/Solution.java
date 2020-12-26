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
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int oneCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res = Math.min(res, bfs(grid, new Pair(i, j), oneCount));
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int bfs(int[][] grid, Pair start, int oneCount) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(start);
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        int step = 0, disSum = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (Pair next : getNexts(cur, grid, visited)) {
                    visited.add(next);
                    if (grid[next.x][next.y] == 0) {
                        queue.offer(next);
                    }
                    
                    if (grid[next.x][next.y] == 1) {
                        disSum += step;
                        oneCount--;
                    }
                }
            }
        }
        
        return oneCount == 0 ? disSum : Integer.MAX_VALUE;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] grid, Set<Pair> visited) {
        List<Pair> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
            if (0 <= nextX && nextX < grid.length && 0 <= nextY && nextY < grid[0].length && grid[nextX][nextY] != 2) {
                Pair next = new Pair(nextX, nextY);
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {1, 0, 0, 2, 1},
                {0, 1, 0, 0, 0}};
        System.out.println(new Solution().shortestDistance(grid));
    }
}
