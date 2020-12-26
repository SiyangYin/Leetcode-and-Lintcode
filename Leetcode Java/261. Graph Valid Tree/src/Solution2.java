import java.util.Arrays;

public class Solution2 {
    
    class UnionFind {
        private int[] parent, sz;
        UnionFind(int size) {
            parent = new int[size];
            sz = new int[size];
            Arrays.fill(sz, 1);
            
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        private int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            
            return p;
        }
        
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        
        public void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            
            if (sz[pRoot] < sz[qRoot]) {
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            unionFind.union(edges[i][0], edges[i][1]);
        }
        
        
        return false;
    }
}
