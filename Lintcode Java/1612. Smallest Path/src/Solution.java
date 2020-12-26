public class Solution {
    /**
     * @param matrix:
     * @return: Return the smallest path
     */
    public int smallestPath(int[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
    
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j - 1; k <= j + 1; k++) {
                    if (0 <= k && k < matrix[0].length) {
                        min = Math.min(min, matrix[i - 1][k]);
                    }
                }
                matrix[i][j] += min;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            res = Math.min(res, matrix[matrix.length - 1][i]);
        }
    
        return res;
    }
}
