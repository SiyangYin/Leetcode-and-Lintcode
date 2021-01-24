public class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0, n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][i] + mat[i][n - 1 - i];
            if (i == n - 1 - i) {
                res -= mat[i][i];
            }
        }
        
        return res;
    }
}
