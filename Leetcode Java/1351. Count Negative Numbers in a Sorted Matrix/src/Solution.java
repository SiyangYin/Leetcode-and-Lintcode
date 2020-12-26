public class Solution {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        int n = grid.length, m = grid[0].length;
        int x = 0, y = m - 1;
        while (x < grid.length) {
            while (y >= 0 && grid[x][y] < 0) {
                y--;
            }
            
            if (y < m - 1) {
                y++;
            }
            
            if (grid[x][y] < 0) {
                res += m - y;
            }
            
            x++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{3, 2}, {-3, -3}};
        System.out.println(new Solution().countNegatives(grid));
    }
}
