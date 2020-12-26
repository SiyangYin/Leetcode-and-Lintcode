import java.util.Arrays;

public class Solution {
    /**
     * @param matrix: a 0-1 matrix
     * @return: return a matrix
     */
    public int[][] updateMatrix(int[][] matrix) {
        // write your code here
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], m + n);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (i < m - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
        }
        
        return dp;
    }
    
    public static void main(String[] args) {
        // int[][] matrix = {
        //         {1, 0, 1, 1, 0},
        //         {1, 1, 0, 0, 1},
        //         {0, 0, 0, 1, 0},
        //         {1, 0, 1, 1, 1},
        //         {1, 0, 0, 0, 1}};
        
        int[][] matrix = {
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        int[][] matrix1 = new Solution().updateMatrix(matrix);
        // System.out.println(Arrays.deepToString(new Solution2().updateMatrix(matrix)));
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
        
        int[][] res = {
                {0, 0, 1, 0, 1, 2, 1, 0, 1, 2},
                {1, 1, 2, 1, 0, 1, 1, 1, 2, 3},
                {2, 1, 2, 1, 1, 0, 0, 0, 1, 2},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 2},
                {0, 0, 1, 1, 1, 0, 1, 1, 2, 3},
                {1, 0, 1, 2, 1, 1, 1, 2, 1, 2},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 2},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 2, 1, 0}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix1[i][j] != res[i][j]) {
                    System.out.println(i + "   " + j);
                }
            }
        }
    }
}
