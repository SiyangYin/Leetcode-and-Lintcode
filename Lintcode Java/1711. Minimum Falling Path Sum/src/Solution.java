public class Solution {
    /**
     * @param A: the given array
     * @return: the minimum sum of a falling path
     */
    public int minFallingPathSum(int[][] A) {
        // Write your code here
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = -1; k <= 1; k++) {
                    int idx = j + k;
                    if (0 <= idx && idx < A[0].length) {
                        min = Math.min(min, A[i - 1][idx]);
                    }
                }
                
                A[i][j] += min;
            }
        }
    
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            res = Math.min(res, A[A.length - 1][i]);
        }
        
        return res;
    }
}
