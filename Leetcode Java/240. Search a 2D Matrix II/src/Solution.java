public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
