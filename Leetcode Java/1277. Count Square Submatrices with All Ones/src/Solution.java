public class Solution {
    public int countSquares(int[][] mat) {
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                
                int up = mat[i - 1][j], left = mat[i][j - 1];
                if (up != left) {
                    mat[i][j] = 1 + Math.min(up, left);
                } else {
                    mat[i][j] = up + (mat[i - up][j - left] != 0 ? 1 : 0);
                }
            }
        }
    
        int res = 0;
        for (int[] row : mat) {
            for (int x : row) {
                res += x;
            }
        }
        
        return res;
    }
}
