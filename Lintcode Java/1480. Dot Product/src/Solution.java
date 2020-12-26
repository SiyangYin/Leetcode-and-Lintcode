public class Solution {
    /**
     * @param A: an array
     * @param B: an array
     * @return: dot product of two array
     */
    public int dotProduct(int[] A, int[] B) {
        // Write your code here
        if (A.length != B.length || A.length == 0) {
            return -1;
        }
        
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res += A[i] * B[i];
        }
        
        return res;
    }
}
