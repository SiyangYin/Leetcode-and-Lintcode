public class Solution {
    
    class UnionFind {
        private int[] parent, rank;
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
        
        public boolean union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) {
                return false;
            }
            
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
            
            return true;
        }
    }
    
    /**
     * @param edges: List[List[int]]
     * @return: List[int]
     */
    public int[] findRedundantConnection(int[][] edges) {
        // write your code here
        if (edges == null || edges.length == 0) {
            return null;
        }
        
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        
        return null;
    }
}
