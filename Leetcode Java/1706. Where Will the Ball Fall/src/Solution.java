public class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = dfs(0, i, grid);
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] g) {
        if (x == g.length - 1) {
            if (g[x][y] == 1) {
                return y + 1 < g[0].length ? g[x][y + 1] == 1 ? y + 1 : -1 : -1;
            } else {
                return y - 1 >= 0 ? g[x][y - 1] == -1 ? y - 1 : -1 : -1;
            }
        }
        
        if (g[x][y] == 1) {
            return y + 1 < g[0].length ? g[x][y + 1] == 1 ? dfs(x + 1, y + 1, g) : -1 : -1;
        } else {
            return y - 1 >= 0 ? g[x][y - 1] == -1 ? dfs(x + 1, y - 1, g) : -1 : -1;
        }
    }
}
