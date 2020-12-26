public class Solution {
    /**
     * @param matrix: a lists of integers
     * @return: nothing
     */
    public void rotate(int[][] matrix) {
        // write your code here
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int[] row : matrix) {
            flip(row);
        }
    }
    
    private void flip(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
    
    private void swap(int[][] A, int x1, int y1, int x2, int y2) {
        int tmp = A[x1][y1];
        A[x1][y1] = A[x2][y2];
        A[x2][y2] = tmp;
    }
}
