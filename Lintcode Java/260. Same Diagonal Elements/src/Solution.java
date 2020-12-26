public class Solution {
    /**
     * @param matrix: a matrix
     * @return: return true if same.
     */
    public boolean judgeSame(int[][] matrix) {
        // write your code here.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
