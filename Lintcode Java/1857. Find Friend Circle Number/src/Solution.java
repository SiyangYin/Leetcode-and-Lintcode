public class Solution {
    
    class UnionFind {
        private int[] parent;
        private int group;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            group = n;
        }
        
        private int find(int x) {
            if (x != parent[x]) {
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
            group--;
        }
        
        public int getGroup() {
            return group;
        }
    }
    
    /**
     * @param M: a matrix of integer
     * @return: return an Integer
     */
    public int findCircleNum(int[][] M) {
        // write your code here
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
    
        UnionFind uf = new UnionFind(M.length);
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getGroup();
    }
}
