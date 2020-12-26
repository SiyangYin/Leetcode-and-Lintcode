public class Solution {
    /**
     * @param A: a array
     * @return: is it monotonous
     */
    public boolean isMonotonic(int[] A) {
        // Write your code here.
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dec = false;
            }
            if (A[i] < A[i - 1]) {
                inc = false;
            }
        }
        
        return inc || dec;
    }
}
