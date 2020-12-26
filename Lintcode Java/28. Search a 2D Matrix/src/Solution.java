public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // m is the number of rows, n being the number of columns
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0, end = m * n - 1;
        int rowIndex = 0, columnIndex = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getNum(matrix, mid) < target) {
                start = mid + 1;
            } else if (getNum(matrix, mid) > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        if (getNum(matrix, start) == target || getNum(matrix, end) == target) {
            return true;
        }
        return false;
    }
    
    public int getNum(int[][] matrix, int index) {
        int numOfColumns = matrix[0].length;
        return matrix[index / numOfColumns][index % numOfColumns];
    }
}