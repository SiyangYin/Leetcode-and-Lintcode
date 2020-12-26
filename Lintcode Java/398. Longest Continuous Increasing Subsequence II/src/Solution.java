public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, dp, matrix));
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] dp, int[][] matrix) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        
        dp[x][y] = 1;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < matrix.length && 0 <= nextY && nextY < matrix[0].length && matrix[nextX][nextY] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(nextX, nextY, dp, matrix));
            }
        }
        
        return dp[x][y];
    }
}
