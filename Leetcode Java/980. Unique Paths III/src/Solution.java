public class Solution {
    
    private int res;
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx = 0, sy = 0, left = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == -1) {
                    left--;
                }
            }
        }
        
        int[] d = {1, 0, -1, 0, 1};
        dfs(sx * n + sy, grid, 0, left, d);
        return res;
    }
    
    private void dfs(int v, int[][] grid, int visited, int left, int[] d) {
        int n = grid[0].length;
        int x = v / n, y = v % n;
        visited |= 1 << v;
        left--;
        
        if (left == 0 && grid[x][y] == 2) {
            res++;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            int nextV = nextX * n + nextY;
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] != -1 && ((visited >> nextV) & 1) == 0) {
                dfs(nextX * n + nextY, grid, visited, left, d);
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new Solution().uniquePathsIII(g));
    }
}

