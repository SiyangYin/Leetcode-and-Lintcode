import java.util.Arrays;

public class Solution {
    
    class UnionFind {
        
        private int[] parent;
        
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return false;
            }
            
            parent[px] = py;
            return true;
        }
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        
        int[] father = new int[n + 1];
        Arrays.fill(father, -1);
        int[][] res = null;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (father[to] != -1) {
                res = new int[][]{{father[to], to}, {from, to}};
                edge[0] = edge[1] = -1;
                break;
            }
            
            father[to] = from;
        }
        
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (from == -1 || to == -1) {
                continue;
            }
            
            if (!uf.union(from, to)) {
                return res == null ? edge : res[0];
            }
        }
        
        return res[1];
    }
    
    public static void main(String[] args) {
        int[][] e = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        System.out.println(Arrays.toString(new Solution().findRedundantDirectedConnection(e)));
    }
}
