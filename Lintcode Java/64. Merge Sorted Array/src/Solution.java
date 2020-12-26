import java.util.Arrays;

public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int ind = m + n - 1;
        while (m > 0 && n > 0) {
            if (A[m - 1] >= B[n - 1]) {
                A[ind--] = A[m-- - 1];
            } else {
                A[ind--] = B[n-- - 1];
            }
        }
        
        while (m > 0) {
            A[ind--] = A[m-- - 1];
        }
        while (n > 0) {
            A[ind--] = B[n-- - 1];
        }
    
        System.out.println(Arrays.toString(A));
    }
    
    public static void main(String[] args) {
        new Solution().mergeSortedArray(new int[]{1, 2, 3, 0, 0}, 3,
                new int[]{4, 5}, 2);
        
    }
}