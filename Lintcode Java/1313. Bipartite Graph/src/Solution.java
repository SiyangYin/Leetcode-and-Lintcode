import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    class Edge {
        int x, y, len;
        
        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    class UnionFind {
        int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return;
            }
            
            parent[px] = py;
        }
    }
    
    /**
     * @param graph: graph edge value
     * @return: return the minium length of graph
     */
    public int getMiniumValue(int[][] graph) {
        // write your code here.
        int n = graph.length;
        List<Edge> list = new ArrayList<>();
        List<Set<Integer>> ops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ops.add(new HashSet<>());
        }
        
        for (int i = 0; i < n; i++) {
            int[] edges = graph[i];
            for (int j = i + 1; j < edges.length; j++) {
                list.add(new Edge(i, j, edges[j]));
            }
        }
        
        list.sort((e1, e2) -> -Integer.compare(e1.len, e2.len));
        UnionFind uf = new UnionFind(n);
        
        for (Edge edge : list) {
            int x = edge.x, y = edge.y;
            if (uf.find(x) == uf.find(y)) {
                return edge.len;
            }
            
            if (!ops.get(x).contains(y)) {
                for (int op : ops.get(x)) {
                    uf.union(op, y);
                }
                ops.get(x).add(y);
                if (ops.get(x).size() == n - 1) {
                    return edge.len;
                }
            }
            
            if (!ops.get(y).contains(x)) {
                for (int op : ops.get(y)) {
                    uf.union(op, x);
                }
                ops.get(y).add(x);
                if (ops.get(y).size() == n - 1) {
                    return edge.len;
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 270, 60, 20}, {270, 0, 35, 90}, {60, 35, 0, 100}, {20, 90, 100, 0}};
        System.out.println(new Solution().getMiniumValue(g));
    }
}
