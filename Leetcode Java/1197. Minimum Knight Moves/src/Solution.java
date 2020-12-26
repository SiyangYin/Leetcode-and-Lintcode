import java.util.*;

public class Solution {
    class Pair {
        int x, y;
        Pair(int x, int y) {
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
    
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        int[][] dirs = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {-1, -2}, {-2, -1}};
        Queue<Pair> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Pair> beginVisited = new HashSet<>(), endVisited = new HashSet<>();
        Pair start = new Pair(0, 0), end = new Pair(x, y);
        beginQueue.offer(start);
        beginVisited.add(start);
        endQueue.offer(end);
        endVisited.add(end);
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            
            res++;
            for (int i = 0; i < beginSize; i++) {
                Pair cur = beginQueue.poll();
                for (Pair next : getNexts(cur, beginVisited, dirs, x, y)) {
                    if (endVisited.contains(next)) {
                        return res;
                    }
                    beginQueue.offer(next);
                    beginVisited.add(next);
                }
            }
            
            res++;
            for (int i = 0; i < endSize; i++) {
                Pair cur = endQueue.poll();
                for (Pair next : getNexts(cur, endVisited, dirs, x, y)) {
                    if (beginVisited.contains(next)) {
                        return res;
                    }
                    endQueue.offer(next);
                    endVisited.add(next);
                }
            }
        }
        
        return 0;
    }
    
    private Set<Pair> getNexts(Pair cur, Set<Pair> visited, int[][] dirs, int destX, int destY) {
        Set<Pair> nexts = new HashSet<>();
        for (int i = 0; i < dirs.length; i++) {
            int nextX = cur.x + dirs[i][0], nextY = cur.y + dirs[i][1];
            if (nextX < -1 || nextX > destX + 2 || nextY < -1 || nextY > destY + 2) {
                continue;
            }
            
            Pair nextP = new Pair(nextX, nextY);
            if (!visited.contains(nextP)) {
                nexts.add(nextP);
            }
        }
        
        return nexts;
    }
}
