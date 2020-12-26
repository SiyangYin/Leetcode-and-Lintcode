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
    /**
     * @param targetMap:
     * @return: nothing
     */
    public int shortestPath(int[][] targetMap) {
        // Write your code here
        Queue<Pair> beginQueue = new ArrayDeque<>(), endQueue = new ArrayDeque<>();
        Set<Pair> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Pair s = new Pair(0, 0);
        beginQueue.offer(s);
        beginSet.add(s);
        Pair e = new Pair(0, 0);
        for (int i = 0; i < targetMap.length; i++) {
            for (int j = 0; j < targetMap[0].length; j++) {
                if (targetMap[i][j] == 2) {
                    e.x = i;
                    e.y = j;
                    endQueue.offer(e);
                    endSet.add(e);
                    break;
                }
            }
            if (!endQueue.isEmpty()) {
                break;
            }
        }
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            
            res++;
            for (int i = 0; i < beginSize; i++) {
                Pair cur = beginQueue.poll();
                for (Pair next : getNexts(cur, targetMap)) {
                    if (endSet.contains(next)) {
                        return res;
                    }
                    if (beginSet.add(next)) {
                        beginQueue.offer(next);
                    }
                }
            }
            
            res++;
            for (int i = 0; i < endSize; i++) {
                Pair cur = endQueue.poll();
                for (Pair next : getNexts(cur, targetMap)) {
                    if (beginSet.contains(next)) {
                        return res;
                    }
                    if (endSet.add(next)) {
                        endQueue.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private List<Pair> getNexts(Pair cur, int[][] matrix) {
        List<Pair> nexts = new ArrayList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int nextX = cur.x + dirs[i][0], nextY = cur.y + dirs[i][1];
            if (0 <= nextX && nextX < matrix.length && 0 <= nextY && nextY < matrix[0].length && matrix[nextX][nextY] != 1) {
                nexts.add(new Pair(nextX, nextY));
            }
        }
        
        return nexts;
    }
}
