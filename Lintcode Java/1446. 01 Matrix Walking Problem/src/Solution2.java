import java.util.*;

public class Solution2 {
    
    class Pair {
        int x, y;
        boolean hasWall;
    
        public Pair(int x, int y, boolean hasWall) {
            this.x = x;
            this.y = y;
            this.hasWall = hasWall;
        }
    
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y && hasWall == pair.hasWall;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y, hasWall);
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
        Pair start = new Pair(0, 0, false);
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (Pair next : getNexts(cur, grid, visited)) {
                    int x = next.x, y = next.y;
                    if (x == m - 1 && y == n - 1) {
                        return step;
                    }
                    
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return -1;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] grid, Set<Pair> visited) {
        List<Pair> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
            if (inBound(nextX, nextY, grid)) {
                Pair next = null;
                if (cur.hasWall && grid[nextX][nextY] == 0) {
                    next = new Pair(nextX, nextY, true);
                }
                if (!cur.hasWall) {
                    next = new Pair(nextX, nextY, grid[nextX][nextY] == 1);
                }
                
                if (next != null && !visited.contains(next)) {
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
                {1, 1, 1, 1, 0}};
        System.out.println(new Solution2().getBestRoad(g));
    }
}
