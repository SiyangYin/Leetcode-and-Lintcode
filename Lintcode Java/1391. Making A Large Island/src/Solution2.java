import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    
    class UnionFind {
        private int[] parent, size;
        
        public UnionFind(int size) {
            parent = new int[size];
            Arrays.fill(parent, -1);
            
            this.size = new int[size];
        }
        
        public void add(int x) {
            if (parent[x] != -1) {
                return;
            }
            
            parent[x] = x;
            size[x] = 1;
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
            size[py] += size[px];
        }
        
        public int size(int x) {
            return size[find(x)];
        }
    }
    
    /**
     * @param grid:
     * @return: nothing
     */
    public int largestIsland(int[][] grid) {
        // Write your code here
        UnionFind uf = new UnionFind(grid.length * grid[0].length);
        
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    uf.add(transform(i, j, grid));
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + d[k], nextY = j + d[k + 1];
                        if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1) {
                            uf.add(transform(nextX, nextY, grid));
                            uf.union(transform(i, j, grid), transform(nextX, nextY, grid));
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, uf.size(transform(i, j, grid)));
                } else {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + d[k], nextY = j + d[k + 1];
                        if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1) {
                            set.add(uf.find(transform(nextX, nextY, grid)));
                        }
                    }
                    
                    int area = 1;
                    for (int e : set) {
                        area += uf.size(e);
                    }
                    
                    res = Math.max(res, area);
                }
            }
        }
        
        return res;
    }
    
    private int transform(int x, int y, int[][] grid) {
        return x * grid[0].length + y;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().largestIsland(new int[][]{{1, 0}, {0, 1}}));
    }
}
