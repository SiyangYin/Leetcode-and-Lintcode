import java.util.Arrays;

public class Solution {
    
    class UnionFind {
        private int[] parent, size;
        private int group;
        
        public UnionFind(int size) {
            parent = new int[size];
            this.size = new int[size];
            Arrays.fill(parent, -1);
        }
        
        public void insert(int x) {
            if (parent[x] != -1) {
                return;
            }
            
            parent[x] = x;
            size[x] = 1;
            group++;
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
            group--;
        }
    }
    
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    uf.insert(transform(i, j, n));
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + d[k], nextJ = j + d[k + 1];
                        if (inBound(nextI, nextJ, grid) && grid[nextI][nextJ] == 1) {
                            uf.insert(transform(nextI, nextJ, n));
                            uf.union(transform(i, j, n), transform(nextI, nextJ, n));
                        }
                    }
                }
            }
        }
        
        if (uf.group == 0 || uf.group > 1) {
            return 0;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int v = transform(i, j, n);
                    if (uf.size[uf.find(v)] == 1) {
                        return 1;
                    }
                    
                    return dfs(v, v, 0, new int[m * n], new int[m * n], new boolean[m * n], grid) ? 1 : 2;
                }
            }
        }
        
        return 0;
    }
    
    private boolean dfs(int v, int parent, int cnt, int[] ord, int[] low, boolean[] visited, int[][] grid) {
        visited[v] = true;
        low[v] = ord[v] = cnt;
        cnt++;
        
        int child = 0;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int n = grid[0].length;
            int nextX = v / n + d[i], nextY = v % n + d[i + 1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1) {
                int w = transform(nextX, nextY, n);
                if (!visited[w]) {
                    if (dfs(w, v, cnt, ord, low, visited, grid)) {
                        return true;
                    }
                    
                    low[v] = Math.min(low[v], low[w]);
                    if (v != parent && low[w] >= ord[v]) {
                        return true;
                    }
                    
                    child++;
                    if (v == parent && child > 1) {
                        return true;
                    }
                } else if (w != parent) {
                    low[v] = Math.min(low[v], low[w]);
                }
            }
        }
        
        return false;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    private int transform(int x, int y, int n) {
        return x * n + y;
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {1, 0, 1},
                {1, 1, 1},
                {1, 0, 1}};
        System.out.println(new Solution().minDays(g));
    }
}
