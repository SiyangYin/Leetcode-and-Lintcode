import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        
        int l = 0, r = A.length - k;
        while (l < r) {
            int m = l + (r - l >> 1);
            int left = A[m];
            if (m + k == A.length) {
                r = m;
                continue;
            }
            
            int right = A[m + k];
            if (Math.abs(left - target) <= Math.abs(right - target)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
    
        r = l + k - 1;
        int idx = 0;
        while (l <= r) {
            if (Math.abs(A[l] - target) <= Math.abs(A[r] - target)) {
                res[idx++] = A[r--];
            } else {
                res[idx++] = A[l++];
            }
        }
        
        reverse(res);
        return res;
    }
    
    private void reverse(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            swap(A, i, j);
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kClosestNumbers(new int[]{1, 3, 6, 8}, 1, 3)));
    }
}