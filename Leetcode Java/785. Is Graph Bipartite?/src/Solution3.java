public class Solution3 {
    
    class UnionFind {
        private int[] p;
    
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
        }
        
        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        public void union(int x, int y) {
            p[find(x)] = find(y);
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int ne : graph[i]) {
                if (uf.find(i) == uf.find(ne)) {
                    return false;
                }
                
                uf.union(graph[i][0], ne);
            }
        }
        
        return true;
    }
}
