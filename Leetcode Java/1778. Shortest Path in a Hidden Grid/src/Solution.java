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
    
    private Pair target;
    
    public int findShortestPath(GridMaster master) {
        char[] d = {'U', 'R', 'D', 'L'};
        int[] dir = {-1, 0, 1, 0, -1};
        Pair start = new Pair(0, 0);
        Map<Pair, Integer> map = new HashMap<>();
        dfs(start, map, master, d, dir);
        return target == null ? -1 : bfs(start, target, map, dir);
    }
    
    private int bfs(Pair start, Pair target, Map<Pair, Integer> map, int[] dir) {
        Queue<Pair> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Pair> beginVis = new HashSet<>(), endVis = new HashSet<>();
        beginQueue.offer(start);
        endQueue.offer(target);
        beginVis.add(start);
        endVis.add(target);
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            res++;
            if (beginQueue.size() <= endQueue.size()) {
                if (oneStep(beginQueue, beginVis, endVis, map, dir)) {
                    return res;
                }
            } else {
                if (oneStep(endQueue, endVis, beginVis, map, dir)) {
                    return res;
                }
            }
        }
        
        return -1;
    }
    
    private boolean oneStep(Queue<Pair> beginQueue, Set<Pair> beginVis, Set<Pair> endVis, Map<Pair, Integer> map, int[] dir) {
        for (int i = beginQueue.size() - 1; i >= 0; i--) {
            Pair cur = beginQueue.poll();
            for (int j = 0; j < 4; j++) {
                Pair next = new Pair(cur.x + dir[j], cur.y + dir[j + 1]);
                if (map.get(next) != 0) {
                    if (endVis.contains(next)) {
                        return true;
                    }
                    
                    if (beginVis.add(next)) {
                        beginQueue.offer(next);
                    }
                }
            }
        }
        
        return false;
    }
    
    private void dfs(Pair cur, Map<Pair, Integer> map, GridMaster master, char[] d, int[] dir) {
        if (master.isTarget()) {
            map.put(cur, 2);
            target = cur;
        } else {
            map.put(cur, 1);
        }
        
        int x = cur.x, y = cur.y;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i], nextY = y + dir[i + 1];
            Pair next = new Pair(nextX, nextY);
            if (map.containsKey(next)) {
                continue;
            }
            
            if (master.canMove(d[i])) {
                master.move(d[i]);
                dfs(next, map, master, d, dir);
                master.move(d[(i + 2) % 4]);
            } else {
                map.put(next, 0);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {0, 0, -1},
                {1, 1, 1},
                {2, 0, 0}};
        int[] cur = {0, 2};
        GridMaster master = new GridMasterImpl(g, cur);
        System.out.println(new Solution().findShortestPath(master));
    }
}

class GridMasterImpl extends GridMaster {
    
    int[][] g;
    int[] cur;
    Map<Character, int[]> map = Map.of('U', new int[]{-1, 0},
            'D', new int[]{1, 0}, 'L', new int[]{0, -1}, 'R', new int[]{0, 1});
    
    public GridMasterImpl(int[][] g, int[] cur) {
        this.g = g;
        this.cur = cur;
    }
    
    @Override
    boolean canMove(char direction) {
        int[] dir = map.get(direction);
        int nextX = cur[0] + dir[0], nextY = cur[1] + dir[1];
        return 0 <= nextX && nextX < g.length && 0 <= nextY && nextY < g[0].length && g[nextX][nextY] != 0;
    }
    
    @Override
    void move(char direction) {
        int[] dir = map.get(direction);
        cur[0] += dir[0];
        cur[1] += dir[1];
    }
    
    @Override
    boolean isTarget() {
        return g[cur[0]][cur[1]] == 2;
    }
}

abstract class GridMaster {
    abstract boolean canMove(char direction);
    
    abstract void move(char direction);
    
    abstract boolean isTarget();
}