public class Solution2 {
    
    class UnionFind {
        int[] parent, rank;
        int group;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            
            group = n;
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
            
            group--;
        }
    }
    
    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return true;
        }
        
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.group == 1;
    }
}
