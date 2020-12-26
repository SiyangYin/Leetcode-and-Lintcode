public class Solution {
    /**
     * @param A:
     * @param K:
     * @return: return a integer
     */
    public int smallestRangeI(int[] A, int K) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int min = A[0], max = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        
        return Math.max((max - K) - (min + K), 0);
    }
}
