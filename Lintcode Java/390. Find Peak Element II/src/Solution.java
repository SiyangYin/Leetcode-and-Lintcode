import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        int l = 1, r = A.length - 2;
        while (l <= r) {
            int m = l + (r - l >> 1);
            int max = Integer.MIN_VALUE, maxIdx = 0;
            for (int i = 0; i < A[m].length; i++) {
                if (A[m][i] > max) {
                    max = A[m][i];
                    maxIdx = i;
                }
            }
            
            if (max > A[m - 1][maxIdx] && max > A[m + 1][maxIdx]) {
                res.add(m);
                res.add(maxIdx);
                break;
            }
            
            if (max < A[m - 1][maxIdx]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return res;
    }
}
