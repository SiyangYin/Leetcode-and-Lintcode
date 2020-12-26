public class Solution {
    /**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here
        int[][] matrix = new int[n][n];
        fillMatrix(matrix, n, 1, 0);
        return matrix;
    }
    
    public void fillMatrix(int[][] matrix, int size, int num, int offset) {
        if (size == 0) {
            return;
        }
        
        if (size == 1) {
            matrix[offset][offset] = num;
            return;
        }
    
        for (int i = 0; i < size - 1; i++) {
            matrix[offset][offset + i] = num + i;
            matrix[offset + i][offset + size - 1] = num + (size - 1) + i;
            matrix[offset + size - 1][offset + size - 1 - i] =
                    num + 2 * (size - 1) + i;
            matrix[offset + size - 1 - i][offset] = num + 3 * (size - 1) + i;
        }
        
        fillMatrix(matrix, size - 2, num + 4 * (size - 1), offset + 1);
    }
    
    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}