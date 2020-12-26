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
     * @return: return the minium distance
     */
    public int getMinDistance(int[][] grid) {
        // write your code here
        Map<Integer, List<Pair>> map = new HashMap<>();
        Pair start = new Pair(0, 0), end = new Pair(0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -2) {
                    start.x = i;
                    start.y = j;
                } else if (grid[i][j] == -3) {
                    end.x = i;
                    end.y = j;
                } else if (grid[i][j] > 0) {
                    map.putIfAbsent(grid[i][j], new ArrayList<>());
                    map.get(grid[i][j]).add(new Pair(i, j));
                }
            }
        }
        
        Queue<Pair> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Pair> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginQueue.offer(start);
        beginSet.add(start);
        endQueue.offer(end);
        endSet.add(end);
        
        int step = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            if (oneStep(beginQueue, beginSet, endSet, grid, map)) {
                return step;
            }
            
            step++;
            if (oneStep(endQueue, endSet, beginSet, grid, map)) {
                return step;
            }
        }
        
        return -1;
    }
    
    private boolean oneStep(Queue<Pair> beginQueue, Set<Pair> beginSet, Set<Pair> endSet, int[][] grid, Map<Integer, List<Pair>> map) {
        int size = beginQueue.size();
        for (int i = 0; i < size; i++) {
            Pair cur = beginQueue.poll();
            for (Pair next : getNexts(cur, grid, beginSet, endSet, map)) {
                if (endSet.contains(next)) {
                    return true;
                }
                
                beginQueue.offer(next);
                beginSet.add(next);
            }
        }
        
        return false;
    }
    
    private Set<Pair> getNexts(Pair cur, int[][] grid, Set<Pair> beginSet, Set<Pair> endSet, Map<Integer, List<Pair>> map) {
        Set<Pair> nexts = new HashSet<>();
        int[] d = {1, 0, -1, 0, 1};
        int x = cur.x, y = cur.y;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] != -1) {
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
        
        if (grid[x][y] > 0) {
            for (Pair next : map.get(grid[x][y])) {
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
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 0, -1, 1}, {-2, 0, -1, -3}, {2, 2, 0, 0}};
        System.out.println(new Solution().getMinDistance(g));
    }
}