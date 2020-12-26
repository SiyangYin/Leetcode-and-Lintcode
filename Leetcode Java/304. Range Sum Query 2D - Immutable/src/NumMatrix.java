public class NumMatrix {
    
    int[][] prefixSum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length, m = matrix[0].length;
        prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1] - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }
    
    public static void main(String[] args) {
        // int[][] matrix = {{3, 0, 1, 4, 2},
        //         {5, 6, 3, 2, 1},
        //         {1, 2, 0, 1, 5},
        //         {4, 1, 0, 1, 7},
        //         {1, 0, 3, 0, 5}};
        int[][] matrix = new int[0][0];
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
    }
}
