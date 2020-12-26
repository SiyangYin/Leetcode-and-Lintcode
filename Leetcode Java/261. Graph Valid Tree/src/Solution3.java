public class Solution3 {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    
        for (int i = 0; i < edges.length; i++) {
            int pRoot = find(parent, edges[i][0]);
            int qRoot = find(parent, edges[i][1]);
            
            if (pRoot == qRoot) {
                return false;
            }
            
            parent[pRoot] = qRoot;
        }
        
        return true;
    }
    
    private int find(int[] parent, int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        
        return p;
    }
}
