public class Solution {
    /**
     * @param A: an array
     * @return: any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     */
    public int peakIndexInMountainArray(int[] A) {
        // Write your code here
        int l = 1, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] > A[m - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
}
