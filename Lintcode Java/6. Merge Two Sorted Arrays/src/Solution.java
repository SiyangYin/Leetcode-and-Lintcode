import java.util.Arrays;

public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }
        
        int[] res = new int[A.length + B.length];
        int i = 0, j = 0, ind = 0;
        while (i < A.length || j < B.length) {
            if (i == A.length) {
                while (ind < res.length) {
                    res[ind++] = B[j++];
                }
            } else if (j == B.length) {
                while (ind < res.length) {
                    res[ind++] = A[i++];
                }
            } else {
                if (A[i] <= B[j]) {
                    res[ind++] = A[i++];
                } else {
                    res[ind++] = B[j++];
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().mergeSortedArray(
                new int[]{1, 2, 3, 4},
                new int[]{2, 4, 5, 6})));
    }
}