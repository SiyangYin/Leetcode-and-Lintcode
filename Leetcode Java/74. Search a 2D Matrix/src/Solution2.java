public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            if (matrix[x][y] < target) {
                start = mid + 1;
            } else if (matrix[x][y] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 1};
    
        System.out.println(new Solution2().searchMatrix(matrix, 3));
    }
}
