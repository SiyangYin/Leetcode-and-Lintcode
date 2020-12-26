public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = matrix.length - 1; i > 0; i--) {
            if (!check(matrix, i, 0)) {
                return false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, 0, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean check(int[][] matrix, int i, int j) {
        int n = matrix[i][j];
        i++;
        j++;
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != n) {
                return false;
            }
            i++;
            j++;
        }
        
        return true;
    }
}
