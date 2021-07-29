public class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = dfs(0, i, grid);
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] g) {
        if (x == g.length) {
            return y;
        }
        
        if (g[x][y] == 1) {
            if (y == g[0].length - 1 || g[x][y + 1] == -1) {
                return -1;
            } else {
                return dfs(x + 1, y + 1, g);
            }
        } else {
            if (y == 0 || g[x][y - 1] == 1) {
                return -1;
            } else {
                return dfs(x + 1, y - 1, g);
            }
        }
    }
}
