public class Solution {
    /**
     * @param dungeon: a 2D array
     * @return: return a integer
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // write your code here
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else {
                    int min = Integer.MAX_VALUE;
                    
                    if (i + 1 < m) {
                        min = Math.min(min, dp[i + 1][j] - dungeon[i][j]);
                    }
                    if (j + 1 < n) {
                        min = Math.min(min, dp[i][j + 1] - dungeon[i][j]);
                    }
                    
                    dp[i][j] = Math.max(1, min);
                }
            }
        }
        
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] d = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        System.out.println(new Solution().calculateMinimumHP(d));
    }
}
