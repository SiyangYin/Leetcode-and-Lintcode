import java.util.*;

public class Solution {
    
    class Pair {
        int x, y, cost;
        
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
        char[] dir = {'U', 'R', 'D', 'L'};
        int[] d = {-1, 0, 1, 0, -1};
        Map<Pair, int[]> map = new HashMap<>();
        Pair start = new Pair(0, 0);
        dfs(start, map, master, d, dir);
        return target == null ? -1 : bfs(start, map, d);
    }
    
    private int bfs(Pair start, Map<Pair, int[]> map, int[] d) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.cost, p2.cost));
        minHeap.offer(start);
        Map<Pair, Integer> cost = new HashMap<>();
        cost.put(start, 0);
        Set<Pair> vis = new HashSet<>();
        vis.add(start);
        
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.equals(target)) {
                return cost.get(cur);
            }
            
            vis.add(cur);
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x + d[i], cur.y + d[i + 1]);
                int[] to = map.get(next);
                if (to[0] != 0 && !vis.contains(next)) {
                    if (!cost.containsKey(next) || cost.get(next) > cost.get(cur) + to[1]) {
                        next.cost = cur.cost + to[1];
                        cost.put(next, cost.get(cur) + to[1]);
                        minHeap.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private void dfs(Pair cur, Map<Pair, int[]> map, GridMaster master, int[] d, char[] dir) {
        if (master.isTarget()) {
            target = cur;
            map.put(cur, new int[]{2, cur.cost});
        } else {
            map.put(cur, new int[]{1, cur.cost});
        }
        
        for (int i = 0; i < 4; i++) {
            Pair next = new Pair(cur.x + d[i], cur.y + d[i + 1]);
            if (map.containsKey(next)) {
                continue;
            }
            
            if (master.canMove(dir[i])) {
                next.cost = master.move(dir[i]);
                dfs(next, map, master, d, dir);
                master.move(dir[(i + 2) % 4]);
            } else {
                map.put(next, new int[]{0});
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {0, 3, 1},
                {3, 4, 2},
                {1, 2, 0}};
        int[] st = {2, 0}, ed = {0, 2};
        GridMaster master = new GridMasterImpl(g, st, ed);
        System.out.println(new Solution().findShortestPath(master));
    }
}

class GridMasterImpl extends GridMaster {
    
    private int[] cur, target;
    private int[][] g;
    private Map<Character, int[]> map = Map.of('U', new int[]{-1, 0},
            'D', new int[]{1, 0}, 'L', new int[]{0, -1}, 'R', new int[]{0, 1});
    
    
    public GridMasterImpl(int[][] g, int[] start, int[] target) {
        this.g = g;
        this.cur = start;
        this.target = target;
    }
    
    @Override
    boolean canMove(char direction) {
        int[] dir = map.get(direction);
        int nextX = cur[0] + dir[0], nextY = cur[1] + dir[1];
        return 0 <= nextX && nextX < g.length && 0 <= nextY && nextY < g[0].length && g[nextX][nextY] != 0;
    }
    
    @Override
    int move(char direction) {
        int[] dir = map.get(direction);
        cur[0] += dir[0];
        cur[1] += dir[1];
        return g[cur[0]][cur[1]];
    }
    
    @Override
    boolean isTarget() {
        return Arrays.equals(cur, target);
    }
}

abstract class GridMaster {
    abstract boolean canMove(char direction);
    
    abstract int move(char direction);
    
    abstract boolean isTarget();
}