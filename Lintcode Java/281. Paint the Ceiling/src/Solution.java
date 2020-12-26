public class Solution {
    /**
     * @param s0: the number s[0]
     * @param n:  the number n
     * @param k:  the number k
     * @param b:  the number b
     * @param m:  the number m
     * @param a:  area
     * @return: the way can paint the ceiling
     */
    public long painttheCeiling(int s0, int n, int k, int b, int m, long a) {
        // write your code here
        long[] A = new long[n];
        A[0] = s0;
        for (int i = 1; i < A.length; i++) {
            A[i] = (k * A[i - 1] + b) % m + 1 + A[i - 1];
        }
        
        long res = 0;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            if (A[l] * A[r] <= a) {
                res += 2L * (r - l) + 1;
                l++;
            } else {
                r--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().painttheCeiling(2, 3, 3, 3, 2, 15));
    }
}
