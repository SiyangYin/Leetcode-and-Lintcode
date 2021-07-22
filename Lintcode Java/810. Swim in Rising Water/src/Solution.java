import java.util.Arrays;

public class Solution {
    /**
     * @param grid: the grid
     * @return: the least time you can reach the bottom right square
     */
    public int swimInWater(int[][] grid) {
        // Write your code here
        int l = 0, r = 0;
        for (int[] row : grid) {
            for (int x : row) {
                r = Math.max(r, x);
            }
        }
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[] d = {-1, 0, 1, 0, -1};
        while (l < r) {
            int m = l + (r - l >> 1);
            for (boolean[] row : vis) {
                Arrays.fill(row, false);
            }
            
            if (dfs(0, 0, grid, m, vis, d)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private boolean dfs(int x, int y, int[][] g, int h, boolean[][] vis, int[] d) {
        if (g[x][y] > h) {
            return false;
        }
        
        if (x == g.length - 1 && y == g[0].length - 1) {
            return true;
        }
        
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < g.length && 0 <= nextY && nextY < g[0].length && !vis[nextX][nextY]) {
                if (dfs(nextX, nextY, g, h, vis, d)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 2}, {1, 3}};
        System.out.println(new Solution().swimInWater(g));
    }
}
