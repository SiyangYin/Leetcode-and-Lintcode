public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // search from bottom left to up right
        // x stores the row index, y column index
        int x = matrix.length - 1;
        int y = 0;
        int count = 0;
        while (x >= 0 && y <= matrix[0].length - 1) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                y++;
                x--;
            }
        }
        return count;
    }
}