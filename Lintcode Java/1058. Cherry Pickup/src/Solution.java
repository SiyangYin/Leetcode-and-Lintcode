public class Solution {
    /**
     * @param grid: a grid
     * @return: the maximum number of cherries possible
     */
    public int cherryPickup(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int len = grid.length;
        
        int[][][] dp = new int[2 * len - 1][len][len];
        dp[0][0][0] = grid[0][0];
        
        for (int s = 1; s < dp.length; s++) {
            for (int x1 = 0; x1 < len; x1++) {
                for (int x2 = 0; x2 < len; x2++) {
                    int y1 = s - x1, y2 = s - x2;
                    if (0 <= y1 && y1 < len && 0 <= y2 && y2 < len) {
                        dp[s][x1][x2] = Integer.MIN_VALUE;
                        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                            continue;
                        }
                        
                        int ch = grid[x1][y1];
                        if (x1 != x2) {
                            ch += grid[x2][y2];
                        }
                        
                        int tmp = 0;
                        boolean updated = false;
                        // up up
                        if (x1 >= 1 && x2 >= 1 && dp[s - 1][x1 - 1][x2 - 1] >= 0) {
                            tmp = Math.max(tmp, dp[s - 1][x1 - 1][x2 - 1] + ch);
                            updated = true;
                        }
                        // up left
                        if (x1 >= 1 && dp[s - 1][x1 - 1][x2] >= 0) {
                            tmp = Math.max(tmp, dp[s - 1][x1 - 1][x2] + ch);
                            updated = true;
                        }
                        // left up
                        if (x2 >= 1 && dp[s - 1][x1][x2 - 1] >= 0) {
                            tmp = Math.max(tmp, dp[s - 1][x1][x2 - 1] + ch);
                            updated = true;
                        }
                        
                        // left left
                        if (dp[s - 1][x1][x2] >= 0) {
                            tmp = Math.max(tmp, dp[s - 1][x1][x2] + ch);
                            updated = true;
                        }
                        if (updated) {
                            dp[s][x1][x2] = tmp;
                        }
                    }
                }
            }
        }
        
        return Math.max(dp[dp.length - 1][len - 1][len - 1], 0);
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
        System.out.println(new Solution().cherryPickup(g));
        System.out.println(Integer.MIN_VALUE);
    }
}
