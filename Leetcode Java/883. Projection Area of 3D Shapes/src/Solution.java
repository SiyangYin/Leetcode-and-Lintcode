public class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length, res = 0;
        for (int i = 0; i < n; i++) {
            int r = 0, c = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    res++;
                }
                
                r = Math.max(r, grid[i][j]);
                c = Math.max(c, grid[j][i]);
            }
            
            res += r + c;
        }
        
        return res;
    }
}
