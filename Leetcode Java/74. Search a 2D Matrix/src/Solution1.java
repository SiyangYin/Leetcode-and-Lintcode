public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l1 = 0, r1 = matrix.length - 1;
        while (l1 < r1) {
            int m = l1 + r1 >> 1;
            if (matrix[m][matrix[0].length - 1] < target) {
                l1 = m + 1;
            }
            else {
                r1 = m;
            }
        }
        int l2 = 0, r2 = matrix[0].length - 1;
        while (l2 < r2) {
            int m = l2 + r2 >> 1;
            if (matrix[l1][m] < target) {
                l2 = m + 1;
            }
            else {
                r2 = m;
            }
        }
        return matrix[l1][l2] == target;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 1};
        
        System.out.println(new Solution1().searchMatrix(matrix, 3));
    }
}
