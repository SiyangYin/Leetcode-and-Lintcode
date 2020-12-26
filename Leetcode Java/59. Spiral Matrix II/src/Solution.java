public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int steps = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = steps++;
            }
            top++;
    
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = steps++;
            }
            right--;
    
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = steps++;
            }
            bottom--;
    
            for (int i = bottom; i >= top ; i--) {
                matrix[i][left] = steps++;
            }
            left++;
        }
        return matrix;
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
