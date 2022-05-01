import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        long d;
        int v;
        
        public Pair(long d, int v) {
            this.d = d;
            this.v = v;
        }
    }
    
    int[] h, e, ne, w;
    int idx, MOD = (int) (1e9 + 7);
    
    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
    
    public int countPaths(int n, int[][] roads) {
        int m = roads.length;
        h = new int[n];
        Arrays.fill(h, -1);
        e = new int[m << 1];
        ne = new int[m << 1];
        w = new int[m << 1];
        for (int[] road : roads) {
            int a = road[0], b = road[1], c = road[2];
            add(a, b, c);
            add(b, a, c);
        }
        
        long[] dist = new long[n];
        int[] cnt = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        cnt[0] = 1;
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> heap = new PriorityQueue<>((x, y) -> Long.compare(x.d, y.d));
        heap.offer(new Pair(0, 0));
        while (!heap.isEmpty()) {
            Pair cur = heap.poll();
            int u = cur.v;
            if (vis[u]) {
                continue;
            }
            if (u == n - 1) {
                break;
            }
            vis[u] = true;
            
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (dist[v] > dist[u] + w[i]) {
                    dist[v] = dist[u] + w[i];
                    cnt[v] = cnt[u];
                    heap.offer(new Pair(dist[v], v));
                } else if (dist[v] == dist[u] + w[i]) {
                    cnt[v] = (cnt[v] + cnt[u]) % MOD;
                }
            }
        }
        
        return cnt[n - 1];
    }
}
