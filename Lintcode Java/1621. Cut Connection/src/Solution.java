public class Solution {
    /**
     * @param matrix:
     * @param x:
     * @param y:
     * @return: return the matrix
     */
    public int[][] removeOne(int[][] matrix, int x, int y) {
        // Write your code here
        for (int i = x; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
        
        return matrix;
    }
}