public class Solution {
    /**
     * @param A: an integer array
     * @return: return maxium contiguous non-negative subarray sum
     */
    public int maxNonNegativeSubArray(int[] A) {
        // write your code here
        int res = -1, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                sum = 0;
                continue;
            }
            
            sum += A[i];
            res = Math.max(res, sum);
        }
        
        return res;
    }
}
