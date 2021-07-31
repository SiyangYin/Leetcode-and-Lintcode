import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution2 {
    
    class Pair {
        int x, y, f;
        
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
        start.f = heur(start, target);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.f, p2.f));
        minHeap.offer(start);
        Map<Pair, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            if (cur.equals(target)) {
                return dist.get(cur);
            }
    
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x + dir[i], cur.y + dir[i + 1]);
                if (map.get(next) != 0) {
                    if (!dist.containsKey(next) || dist.get(next) > dist.get(cur) + 1) {
                        dist.put(next, dist.get(cur) + 1);
                        next.f = dist.get(next) + heur(next, target);
                        minHeap.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private int heur(Pair cur, Pair target) {
        return Math.abs(cur.x - target.x) + Math.abs(cur.y - target.y);
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
        System.out.println(new Solution2().findShortestPath(master));
    }
}