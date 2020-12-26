public class NumMatrix {
    
    private int[][] prefixSum;
    
    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] + matrix[i][j] - prefixSum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1] - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }
    
    public static void main(String[] args) {
        int[][] m = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix mat = new NumMatrix(m);
        System.out.println(mat.sumRegion(2, 1, 4, 3));
        System.out.println(mat.sumRegion(1, 1, 2, 2));
    }
}