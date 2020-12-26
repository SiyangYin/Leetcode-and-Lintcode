import java.util.Arrays;

public class Solution {
    /**
     * @param matrix: A lsit of lists of integers
     * @return: nothing
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        boolean firstRow, firstCol;
        firstRow = firstCol = false;
        
        int n = matrix.length, m = matrix[0].length;
    
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
    
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
    
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
    
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if (firstRow) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstCol) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().setZeroes(matrix);
    
        System.out.println(Arrays.deepToString(matrix));
    }
}
