public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int l = 1, r = A.length - 2;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (A[m - 1] < A[m] && A[m] < A[m + 1]) {
                l = m + 1;
            } else if (A[m - 1] > A[m] && A[m] > A[m + 1]) {
                r = m - 1;
            } else if (A[m - 1] > A[m] && A[m] < A[m + 1]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().findPeak(new int[]{100, 102, 104, 7, 9, 11, 4, 3}));
        System.out.println(new Solution().findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6}));
    }
}