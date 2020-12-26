import java.util.*;

public class Solution {
    
    class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object p) {
            Pair pair = (Pair) p;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    /**
     * @param maps:
     * @return: nothing
     */
    public int theMazeIV(char[][] maps) {
        if (maps == null || maps.length == 0 || maps[0].length == 0) {
            return 0;
        }
        
        Queue<Pair> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Pair> beginSet = new HashSet<>(), endSet = new HashSet<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 'S') {
                    Pair start = new Pair(i, j);
                    beginQueue.offer(start);
                    beginSet.add(start);
                }
                if (maps[i][j] == 'T') {
                    Pair end = new Pair(i, j);
                    endQueue.offer(end);
                    endSet.add(end);
                }
            }
        }
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            res++;
            for (int i = 0; i < beginSize; i++) {
                Pair begin = beginQueue.poll();
                for (Pair next : getNext(begin, maps)) {
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
                Pair end = endQueue.poll();
                for (Pair next : getNext(end, maps)) {
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
    
    private List<Pair> getNext(Pair cur, char[][] maps) {
        List<Pair> nexts = new ArrayList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int newX = cur.x + dirs[i][0], newY = cur.y + dirs[i][1];
            if (isValid(newX, newY, maps)) {
                nexts.add(new Pair(newX, newY));
            }
        }
        
        return nexts;
    }
    
    private boolean isValid(int x, int y, char[][] maps) {
        return 0 <= x && x < maps.length && 0 <= y && y < maps[0].length && maps[x][y] != '#';
    }
}
