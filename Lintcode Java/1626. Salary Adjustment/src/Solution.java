public class Solution {
    /**
     * @param A: the list of salary
     * @param target: the target of the sum
     * @return: the cap it should be
     */
    public int getCap(int[] A, int target) {
        // Write your code here.
        int l = target, r = target / A.length + 1;
        for (int i = 0; i < A.length; i++) {
            l = Math.min(l, A[i]);
        }
        
        while (l < r) {
            int m = l + (r - l >> 1);
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += Math.max(A[i], m);
            }
            
            if (sum >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}
