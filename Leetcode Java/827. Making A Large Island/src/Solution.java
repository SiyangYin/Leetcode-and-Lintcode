import java.util.*;

public class Solution {
    
    class UnionFind {
        Map<Pair, Pair> parent;
        Map<Pair, Integer> size;
    
        public UnionFind() {
            parent = new HashMap<>();
            size = new HashMap<>();
        }
    
        public void add(Pair x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                size.put(x, 1);
            }
        }
        
        public Pair find(Pair x) {
            add(x);
            
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x)));
            }
            
            return parent.get(x);
        }
        
        public void union(Pair x, Pair y) {
            Pair px = find(x), py = find(y);
            if (px.equals(py)) {
                return;
            }
            
            parent.put(px, py);
            size.put(py, size.get(px) + size.get(py));
        }
        
        public int getSize(Pair x) {
            return size.get(find(x));
        }
    }
    
    class Pair {
        int x, y;
    
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Pair cur = new Pair(i, j);
                    uf.add(cur);
                    
                    int[] d = {1, 0, -1, 0, 1};
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + d[k], nextJ = j + d[k + 1];
                        if (0 <= nextI && nextI < m && 0 <= nextJ && nextJ < n && grid[nextI][nextJ] == 1) {
                            Pair next = new Pair(nextI, nextJ);
                            uf.union(cur, next);
                        }
                    }
                }
            }
        }
    
        int res = 0;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    found = true;
                    
                    Set<Pair> set = new HashSet<>();
                    int area = 1;
                    int[] d = {1, 0, -1, 0, 1};
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + d[k], nextJ = j + d[k + 1];
                        if (0 <= nextI && nextI < m && 0 <= nextJ && nextJ < n && grid[nextI][nextJ] == 1) {
                            Pair next = new Pair(nextI, nextJ);
                            Pair ancestor = uf.find(next);
                            if (!set.contains(ancestor)) {
                                area += uf.getSize(ancestor);
                                set.add(ancestor);
                            }
                        }
                    }
                    
                    res = Math.max(res, area);
                }
            }
        }
        
        return found ? res : m * n;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 0}, {1, 1}};
        System.out.println(new Solution().largestIsland(g));
    }
}
