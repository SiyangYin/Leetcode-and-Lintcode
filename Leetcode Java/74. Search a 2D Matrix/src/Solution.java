public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        int row = 0;
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        int left = 0, right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        if (matrix[row][left] == target || matrix[row][right] == target) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{{1}}, 1));
    }
}
