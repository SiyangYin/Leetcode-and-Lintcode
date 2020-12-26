import java.util.*;

public class Solution2 {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Solution.Pair pair = (Solution.Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        int[][] dirs = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {-1, -2}, {-2, -1}};
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        Pair start = new Pair(0, 0);
        queue.offer(start);
        visited.add(start);
        
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            res++;
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for (Pair next : getNexts(cur, visited, dirs)) {
                    if (next.x == x && next.y == y) {
                        return res;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return 0;
    }
    
    private Set<Pair> getNexts(Pair cur, Set<Pair> visited, int[][] dirs) {
        Set<Pair> nexts = new HashSet<>();
        for (int i = 0; i < dirs.length; i++) {
            int nextX = cur.x + dirs[i][0], nextY = cur.y + dirs[i][1];
            Pair nextP = new Pair(nextX, nextY);
            if (!visited.contains(nextP) && isOptimal(nextX, nextY)) {
                nexts.add(nextP);
            }
        }
        
        return nexts;
    }
    
    private boolean isOptimal(int x, int y) {
        return -1 <= x && x < 301 && -1 <= y && y < 301;
    }
}
