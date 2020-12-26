public class Solution {
    /**
     * @param A: A matrix
     * @return: A transposed matrix
     */
    public int[][] transpose(int[][] A) {
        // write your code here
        int m = A.length, n = A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = A[i][j];
            }
        }
        
        return res;
    }
}
