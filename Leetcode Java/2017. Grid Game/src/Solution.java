public class Solution {
    public long gridGame(int[][] grid) {
        long sum1 = 0, sum2 = 0;
        for (int i = 1; i < grid[0].length; i++) {
            sum1 += grid[0][i];
        }
    
        long res = sum1;
        for (int i = 1; i < grid[0].length; i++) {
            sum1 -= grid[0][i];
            sum2 += grid[1][i - 1];
            
            res = Math.min(res, Math.max(sum1, sum2));
        }
        
        return res;
    }
}
