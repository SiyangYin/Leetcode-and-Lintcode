public class Solution3 {
    class UnionFind {
        private int[] parent, rank;
        private int count;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            
            return parent[p];
        }
        
        public void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
            count--;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.getCount();
    }
}
