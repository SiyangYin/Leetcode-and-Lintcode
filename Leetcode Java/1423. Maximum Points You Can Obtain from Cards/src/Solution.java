public class Solution {
    public int maxScore(int[] A, int k) {
        int res = 0, lsum = 0, rsum = 0;
        for (int i = 0; i < k; i++) {
            lsum += A[i];
        }
        
        res = Math.max(res, lsum);
        for (int i = 0; i < k; i++) {
            lsum -= A[k - 1 - i];
            rsum += A[A.length - 1 - i];
            res = Math.max(res, lsum + rsum);
        }
        
        return res;
    }
}
