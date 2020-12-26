public class Solution2 {
    public ResultType check(int value, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean exists = false;
        int num = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (matrix[i][j] == value) {
                exists = true;
            }
            if (matrix[i][j] <= value) {
                num += i + 1;
                j += 1;
            } else {
                i -= 1;
            }
        }
        
        return new ResultType(exists, num);
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = matrix[0][0];
        int right = matrix[n - 1][m - 1];
        
        // left + 1 < right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ResultType type = check(mid, matrix);
            if (type.exists && type.num == k) {
                return mid;
            } else if (type.num < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 4},
                {3, 7, 8},
                {4, 8, 9}};
        System.out.println(new Solution2().kthSmallest(matrix, 2));
        System.out.println(new Solution2().kthSmallest(matrix, 3));
        System.out.println(new Solution2().kthSmallest(matrix, 4));
        System.out.println(new Solution2().kthSmallest(matrix, 5));
    }
}

class ResultType {
    public int num;
    public boolean exists;
    public ResultType(boolean e, int n) {
        exists = e;
        num = n;
    }
}