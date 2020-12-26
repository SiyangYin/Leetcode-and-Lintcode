import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        private Map<Integer, Integer> parent;
    
        public UnionFind() {
            parent = new HashMap<>();
        }
    
        void add(int x) {
            parent.putIfAbsent(x, x);
        }
        
        int find(int x) {
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            
            return parent.get(x);
        }
        
        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return false;
            }
            
            parent.put(px, py);
            return true;
        }
    }
    
    class Edge {
        int weight, idx;
        
        public Edge(int weight, int idx) {
            this.weight = weight;
            this.idx = idx;
        }
    }
    
    /**
     * @param n: maximum index of position.
     * @param m: the number of undirected edges.
     * @param x:
     * @param y:
     * @param w:
     * @return: return the minimum risk value.
     */
    public int getMinRiskValue(int n, int m, int[] x, int[] y, int[] w) {
        // Write your code here.
        UnionFind uf = new UnionFind();
        
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(w[i], i);
            uf.add(x[i]);
            uf.add(y[i]);
        }
        
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1.weight, e2.weight));
    
        for (int i = 0; i < edges.length; i++) {
            int idx = edges[i].idx;
            uf.union(x[idx], y[idx]);
            if (uf.find(0) == uf.find(n)) {
                return edges[i].weight;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int n = 3, m = 4;
        int[] x = {0, 0, 1, 2}, y = {1, 2, 3, 3}, w = {1, 2, 3, 4};
        System.out.println(new Solution().getMinRiskValue(n, m, x, y, w));
    }
}
