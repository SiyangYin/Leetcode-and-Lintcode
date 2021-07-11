import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class UnionFind {
        int[] parent;
        int size;
        
        public UnionFind(int size) {
            parent = new int[size];
            this.size = size;
            
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
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
        }
    }
    
    class Edge {
        int x, y, len;
        
        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        
        int m = heights.length, n = heights[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    list.add(new Edge(transform(i, j, n), transform(i, j + 1, n), Math.abs(heights[i][j] - heights[i][j + 1])));
                }
                if (i < m - 1) {
                    list.add(new Edge(transform(i, j, n), transform(i + 1, j, n), Math.abs(heights[i][j] - heights[i + 1][j])));
                }
            }
        }
        
        list.sort((e1, e2) -> Integer.compare(e1.len, e2.len));
        
        UnionFind uf = new UnionFind(m * n);
        int start = 0, end = m * n - 1;
        for (Edge edge : list) {
            uf.union(edge.x, edge.y);
        
            if (uf.find(start) == uf.find(end)) {
                return edge.len;
            }
        }
        
        return 0;
    }
    
    private int transform(int x, int y, int n) {
        return x * n + y;
    }
    
    public static void main(String[] args) {
        int[][] h = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}};
        System.out.println(new Solution().minimumEffortPath(h));
    }
}
