import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    
    class Edge {
        int x, y, len;
        
        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
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
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
            }
        }
    }
    
    /**
     * @param grid: the grid
     * @return: the least time you can reach the bottom right square
     */
    public int swimInWater(int[][] grid) {
        // Write your code here
        int m = grid.length, n = grid[0].length;
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    list.add(new Edge(get(i, j, grid), get(i + 1, j, grid), Math.max(grid[i][j], grid[i + 1][j])));
                }
                if (j + 1 < n) {
                    list.add(new Edge(get(i, j, grid), get(i, j + 1, grid), Math.max(grid[i][j], grid[i][j + 1])));
                }
            }
        }
        
        UnionFind uf = new UnionFind(m * n);
        list.sort((e1, e2) -> Integer.compare(e1.len, e2.len));
        for (Edge e : list) {
            if (uf.find(e.x) == uf.find(e.y)) {
                continue;
            }
            
            uf.union(e.x, e.y);
            if (uf.find(0) == uf.find(m * n - 1)) {
                return e.len;
            }
        }
        
        return -1;
    }
    
    private int get(int x, int y, int[][] g) {
        return x * g[0].length + y;
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 2}, {1, 3}};
        System.out.println(new Solution2().swimInWater(g));
    }
}
