import java.util.Arrays;

public class Solution {
    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            res = Math.min(res, Math.abs(A[i] - B[j]));
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return res;
    }
}
