public class Solution {
    /**
     * @param matrix: A matrix
     * @return: An integer.
     */
    public int longestIncreasingPath(int[][] matrix) {
        // Write your code here.
        int res = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, dp));
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] mat, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        
        int[] d = {1, 0, -1, 0, 1};
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, mat) && mat[nextX][nextY] > mat[x][y]) {
                res = Math.max(res, 1 + dfs(nextX, nextY, mat, dp));
            }
        }
        
        dp[x][y] = res;
        return res;
    }
    
    private boolean inBound(int x, int y, int[][] mat) {
        return 0 <= x && x < mat.length && 0 <= y && y < mat[0].length;
    }
}
