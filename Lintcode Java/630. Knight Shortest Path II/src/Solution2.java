import java.util.*;

public class Solution2 {
    
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
        
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] || grid[m - 1][n - 1]) {
            return -1;
        }
        
        Pair start = new Pair(0, 0), end = new Pair(m - 1, n - 1);
        Queue<Pair> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Pair> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginQueue.offer(start);
        beginSet.add(start);
        endQueue.offer(end);
        endSet.add(end);
        
        int step = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            if (oneStep(beginQueue, beginSet, endSet, grid, 1)) {
                return step;
            }
            
            step++;
            if (oneStep(endQueue, endSet, beginSet, grid, -1)) {
                return step;
            }
        }
        
        return -1;
    }
    
    private boolean oneStep(Queue<Pair> beginQueue, Set<Pair> beginSet, Set<Pair> endSet, boolean[][] grid, int reverse) {
        int size = beginQueue.size();
        for (int i = 0; i < size; i++) {
            Pair cur = beginQueue.poll();
            for (Pair next : getNexts(cur, beginSet, endSet, grid, reverse)) {
                if (endSet.contains(next)) {
                    return true;
                }
                
                beginQueue.offer(next);
                beginSet.add(next);
            }
        }
        
        return false;
    }
    
    private List<Pair> getNexts(Pair cur, Set<Pair> beginSet, Set<Pair> endSet, boolean[][] grid, int reverse) {
        List<Pair> nexts = new ArrayList<>();
        int[] dx = {1, -1, 2, -2}, dy = {2, 2, 1, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + reverse * dx[i], nextY = cur.y + reverse * dy[i];
            if (inBound(nextX, nextY, grid) && !grid[nextX][nextY]) {
                Pair next = new Pair(nextX, nextY);
                if (endSet.contains(next)) {
                    nexts.clear();
                    nexts.add(next);
                    return nexts;
                }
                
                if (!beginSet.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        boolean[][] grid = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}};
        System.out.println(new Solution2().shortestPath2(grid));
    }
}
