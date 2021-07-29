public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int[] d = {-1, 0, 1, 0, -1};
        for (int i = 0, id = 2; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 1) {
                    dfs1(i, j, grid1, d, id++);
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs2(i, j, grid2, grid1, d, grid1[i][j])) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean dfs2(int x, int y, int[][] g, int[][] g1, int[] d, int id) {
        boolean res = id != 0 && g1[x][y] == id;
        
        g[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < g.length && 0 <= nextY && nextY < g[0].length && g[nextX][nextY] == 1) {
                res &= dfs2(nextX, nextY, g, g1, d, id);
            }
        }
        
        return res;
    }
    
    private void dfs1(int x, int y, int[][] g, int[] d, int id) {
        g[x][y] = id;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < g.length && 0 <= nextY && nextY < g[0].length && g[nextX][nextY] == 1) {
                dfs1(nextX, nextY, g, d, id);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] g1 = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}};
        int[][] g2 = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}};
        System.out.println(new Solution().countSubIslands(g1, g2));
    }
}
