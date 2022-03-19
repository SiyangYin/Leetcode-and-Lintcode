public class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, res = 0;
        int[] d = {-1, 0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += calc(i, j, grid, d);
            }
        }
        
        return res;
    }
    
    int calc(int x, int y, int[][] g, int[] d) {
        if (g[x][y] == 0) {
            return 0;
        }
        
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i], ny = y + d[i + 1];
            if (0 <= nx && nx < g.length && 0 <= ny && ny < g.length) {
                cnt += Math.max(0, g[x][y] - g[nx][ny]);
            } else {
                cnt += g[x][y];
            }
        }
        
        return cnt + 2;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 2}, {3, 4}};
        System.out.println(new Solution().surfaceArea(g));
    }
}
