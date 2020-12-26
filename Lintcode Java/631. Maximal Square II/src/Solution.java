public class Solution {
    /**
     * @param matrix: a matrix of 0 an 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        int res = 0;
        int[][] up0 = new int[m][n], left0 = new int[m][n], dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    up0[i][j] = left0[i][j] = 0;
                } else {
                    up0[i][j] = left0[i][j] = 1;
                    if (i > 0) {
                        up0[i][j] += up0[i - 1][j];
                    }
                    if (j > 0) {
                        left0[i][j] += left0[i][j - 1];
                    }
                }
                
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        int min0 = Math.min(left0[i][j - 1], up0[i - 1][j]);
                        dp[i][j] += Math.min(dp[i - 1][j - 1], min0);
                    }
                }
                
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res * res;
    }
}
