public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int left = dp[i][j - 1], up = dp[i - 1][j];
                    if (left != up) {
                        dp[i][j] = Math.min(left, up) + 1;
                    } else {
                        dp[i][j] = matrix[i - left][j - left] == 1 ? left + 1 : left;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res * res;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(new Solution().maxSquare(matrix));
    }
}
