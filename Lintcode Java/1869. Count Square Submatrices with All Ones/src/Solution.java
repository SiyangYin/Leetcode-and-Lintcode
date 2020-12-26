public class Solution {
    /**
     * @param matrix: a matrix
     * @return: return how many square submatrices have all ones
     */
    public int countSquares(int[][] matrix) {
        // write your code here
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1;
                    int left = 0, up = 0;
                    if (i > 0) {
                        left = dp[i - 1][j];
                    }
                    if (j > 0) {
                        up = dp[i][j - 1];
                    }
                    
                    if (left != up) {
                        dp[i][j] = 1 + Math.min(left, up);
                    } else if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(1 + left, 1 + dp[i - 1][j - 1]);
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[i][j];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1}};
        System.out.println(new Solution().countSquares(mat));
    }
}
