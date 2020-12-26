public class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i >= 1) {
                    int lastRow = A[i - 1][j];
                    if (j - 1 >= 0) {
                        lastRow = Math.min(lastRow, A[i - 1][j - 1]);
                    }
                    if (j + 1 < A[0].length) {
                        lastRow = Math.min(lastRow, A[i - 1][j + 1]);
                    }
                    
                    A[i][j] += lastRow;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            res = Math.min(res, A[A.length - 1][i]);
        }
        
        return res;
    }
}
