public class Solution {
    /**
     * @param A: the array A
     * @param B: the array B
     * @return: returns an alternate array of arrays A and B.
     */
    public int[] interleavedArray(int[] A, int[] B) {
        // Interleaved Array
        int i = 0, j = 0;
        int[] res = new int[A.length + B.length];
        int idx = 0;
        while (i < A.length || j < B.length) {
            if (i < A.length) {
                res[idx++] = A[i++];
            }
            if (j < B.length) {
                res[idx++] = B[j++];
            }
        }
        
        return res;
    }
}
