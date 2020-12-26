public class Solution {
    /**
     * @param M: a 2D integer matrix
     * @return: a 2D integer matrix
     */
    public int[][] imageSmoother(int[][] M) {
        // Write your code here
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, neigh = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int nextI = i + k, nextJ = j + l;
                        if (0 <= nextI && nextI < m && 0 <= nextJ && nextJ < n) {
                            sum += M[nextI][nextJ];
                            neigh++;
                        }
                    }
                }
                
                res[i][j] = sum / neigh;
            }
        }
        
        return res;
    }
}
