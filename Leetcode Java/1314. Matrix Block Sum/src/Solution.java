public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] preSum = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                preSum[i + 1][j + 1] = mat[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
        
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int x1 = Math.max(0, i - k), x2 = Math.min(mat.length - 1, i + k);
                int y1 = Math.max(0, j - k), y2 = Math.min(mat[0].length - 1, j + k);
                res[i][j] = sum(preSum, x1, y1, x2, y2);
            }
        }
        
        return res;
    }
    
    private int sum(int[][] preSum, int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
    }
}
