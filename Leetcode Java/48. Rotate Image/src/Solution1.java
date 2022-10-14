public class Solution1 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }

       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix.length; j++) {
               System.out.print(matrix[i][j] + " ");

           }
           System.out.println();
       }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        new Solution1().rotate(matrix);
    }
}
