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
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        if (grid.length == 1 && grid[0].length == 1) {
            return 0;
        }
        
        int res = 0;
        Pair start = new Pair(0, 0);
        Set<Pair> visited = new HashSet<>();
        
        visited.add(start);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (Pair next : getNexts(cur, visited, grid)) {
                    if (next.x == grid.length - 1 && next.y == grid[0].length - 1) {
                        return res;
                    }
                    
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return -1;
    }
    
    private List<Pair> getNexts(Pair cur, Set<Pair> visited, boolean[][] grid) {
        List<Pair> nexts = new ArrayList<>();
        int[] dx = {1, -1, 2, -2}, dy = {2, 2, 1, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + dx[i], nextY = cur.y + dy[i];
            Pair next = new Pair(nextX, nextY);
            if (inBound(nextX, nextY, grid) && !grid[nextX][nextY] && !visited.contains(next)) {
                nexts.add(next);
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        boolean[][] grid = {{false, false, false, false},{false, false, false, false},{false, false, false, false}};
        System.out.println(new Solution().shortestPath2(grid));
    }
}
