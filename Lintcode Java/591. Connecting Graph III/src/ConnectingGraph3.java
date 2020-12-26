public class ConnectingGraph3 {
    
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
    
    UnionFind uf;
    
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        uf = new UnionFind(n);
    }
    
    public void connect(int a, int b) {
        // write your code here
        uf.union(a - 1, b - 1);
    }
    
    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return uf.group;
    }
}