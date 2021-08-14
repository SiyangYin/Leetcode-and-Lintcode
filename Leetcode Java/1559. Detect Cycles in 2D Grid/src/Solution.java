public class Solution {
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
        
        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
                return true;
            }
            
            return false;
        }
    }
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i][j];
                int x = get(i, j, n);
                if (i + 1 < m && grid[i + 1][j] == ch) {
                    if (!uf.union(x, get(i + 1, j, n))) {
                        return true;
                    }
                }
                
                if (j + 1 < n && grid[i][j + 1] == ch) {
                    if (!uf.union(x, get(i, j + 1, n))) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    int get(int x, int y, int n) {
        return x * n + y;
    }
}
