public class Solution {
    
    class UnionFind {
        private int[] p;
        private int size;
        
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
            
            this.size = size;
        }
        
        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
                size--;
            }
        }
        
        public int getSize() {
            return size;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        
        return uf.getSize() - 1;
    }
}
