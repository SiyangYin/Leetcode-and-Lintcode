public class Solution3 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (countLessEq(matrix, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private int countLessEq(int[][] matrix, int target) {
        int x = matrix.length - 1, y = 0, count = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] <= target) {
                count += x + 1;
                y++;
            } else {
                x--;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Solution3().kthSmallest(mat, 8));
    }
}
