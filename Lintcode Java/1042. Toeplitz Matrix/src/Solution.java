public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
    
        for (int i = 0; i < matrix.length; i++) {
            int val = matrix[i][0], dif = 1;
            while (i + dif < matrix.length && dif < matrix[0].length) {
                if (matrix[i + dif][dif] != val) {
                    return false;
                }
                dif++;
            }
        }
    
        for (int i = 0; i < matrix[0].length; i++) {
            int val = matrix[0][i], dif = 1;
            while (dif < matrix.length && i + dif < matrix[0].length) {
                if (matrix[dif][i + dif] != val) {
                    return false;
                }
                dif++;
            }
        }
        
        return true;
    }
}
