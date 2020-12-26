import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        int u = 1, d = A.length - 2, l = 1, r = A[0].length - 2;
        
        while (u <= d && l <= r) {
            int mRow = u + (d - u >> 1), mCol = l + (r - l >> 1);
            
            int max = Integer.MIN_VALUE, maxRow = 0, maxCol = 0;
            for (int i = l; i <= r; i++) {
                if (A[mRow][i] > max) {
                    max = A[mRow][i];
                    maxRow = mRow;
                    maxCol = i;
                }
            }
            for (int i = u; i <= d; i++) {
                if (A[i][mCol] > max) {
                    max = A[i][mCol];
                    maxRow = i;
                    maxCol = mCol;
                }
            }
            
            if (max > A[maxRow - 1][maxCol] && max > A[maxRow + 1][maxCol] && max > A[maxRow][maxCol - 1] && max > A[maxRow][maxCol + 1]) {
                res.add(maxRow);
                res.add(maxCol);
                break;
            }
            
            if (maxRow == mRow) {
                if (A[mRow - 1][maxCol] > max) {
                    d = mRow - 1;
                } else if (A[mRow + 1][maxCol] > max) {
                    u = mRow + 1;
                }
                
                if (maxCol < mCol) {
                    r = maxCol;
                } else {
                    l = maxCol;
                }
            } else if (maxCol == mCol) {
                if (A[maxRow][mCol - 1] > max) {
                    r = mCol - 1;
                } else if (A[maxRow][mCol + 1] > max) {
                    l = mCol + 1;
                }
                
                if (maxRow < mRow) {
                    d = maxRow;
                } else {
                    u = maxRow;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 6, 5},
                {16, 41, 23, 22, 6},
                {15, 17, 24, 21, 7},
                {14, 18, 19, 20, 10},
                {13, 14, 11, 10, 9}};
        System.out.println(new Solution2().findPeakII(A));
    }
}
