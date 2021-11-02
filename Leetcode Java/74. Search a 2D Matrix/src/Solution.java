public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        if (l > r) {
            return false;
        }
        
        while (l < r) {
            int mid = l + (r - l >> 1);
            
            int x = mid / n, y = mid % n;
            if (matrix[x][y] < target) {
                l = mid + 1;
            } else if (matrix[x][y] > target) {
                r = mid;
            }
        }
        
        return matrix[l / n][l % n] == target;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 1};
        
        System.out.println(new Solution().searchMatrix(matrix, 3));
    }
}
