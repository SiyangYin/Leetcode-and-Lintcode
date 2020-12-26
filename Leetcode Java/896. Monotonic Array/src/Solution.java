public class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 2) {
            return true;
        }
    
        boolean incr = true, decr = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                incr = false;
            }
            if (A[i] < A[i + 1]) {
                decr = false;
            }
        }
        
        return incr || decr;
    }
}
