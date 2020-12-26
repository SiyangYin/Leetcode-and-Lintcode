public class Solution {
    /**
     * @param A: an array
     * @return: the maximum value of F(0), F(1), ..., F(n-1)
     */
    public int maxRotateFunction(int[] A) {
        // Write your code here
        int res = Integer.MIN_VALUE, sum = 0, x = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            x += i * A[i];
        }
        
        res = Math.max(res, x);
        for (int i = A.length - 1; i > 0; i--) {
            x = x + sum - A.length * A[i];
            res = Math.max(res, x);
        }
        
        return res;
    }
}
