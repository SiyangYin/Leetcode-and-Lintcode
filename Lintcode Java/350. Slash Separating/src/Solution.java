public class Solution {
    
    class UnionFind {
        private int[] p;
        int group;
        
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
            group = size;
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
                group--;
            }
        }
    }
    
    /**
     * @param grids: the ractangle.
     * @return: return the number of parts after separating.
     */
    public int slashSeparating(String[] grids) {
        // write your code here.
        int m = grids.length, n = grids[0].length();
        UnionFind uf = new UnionFind(m * n * 4);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a0 = (i * n + j) * 4, a1 = a0 + 1, a2 = a1 + 1, a3 = a2 + 1;
                char ch = grids[i].charAt(j);
                if (ch == ' ') {
                    uf.union(a0, a1);
                    uf.union(a1, a2);
                    uf.union(a2, a3);
                } else if (ch == '/') {
                    uf.union(a0, a1);
                    uf.union(a2, a3);
                } else if (ch == '\\') {
                    uf.union(a1, a2);
                    uf.union(a0, a3);
                }
                
                if (j < n - 1) {
                    uf.union(a2, a2 + 2);
                }
                if (i < m - 1) {
                    uf.union(a3, ((i + 1) * n + j) * 4 + 1);
                }
            }
        }
        
        return uf.group;
    }
    
    public static void main(String[] args) {
        String[] strs = {" \\", "/\\"};
        System.out.println(new Solution().slashSeparating(strs));
    }
}
