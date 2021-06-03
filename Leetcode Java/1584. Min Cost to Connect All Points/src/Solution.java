import java.util.PriorityQueue;

public class Solution {
    
    class UnionFind {
        private int[] p;
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
        }
        
        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
                return true;
            }
            
            return false;
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[2], p2[2]));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] x = points[i], y = points[j];
                minHeap.offer(new int[]{i, j, Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1])});
            }
        }
        
        UnionFind uf = new UnionFind(points.length);
        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] p = minHeap.poll();
            int x = p[0], y = p[1];
            if (uf.union(x, y)) {
                res += p[2];
            }
        }
        
        return res;
    }
}
