import java.util.Arrays;

public class Solution {
    /**
     * @param A: a integer sorted array
     * @param B: a integer sorted array
     * @param K: a integer
     * @return: return a pair of index
     */
    public int[] optimalUtilization(int[] A, int[] B, int K) {
        // write your code here
        if (A.length == 0 || B.length == 0) {
            return new int[0];
        }
        
        int[] res = new int[2];
        int curSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int idx = binarySearch(B, K - A[i]);
            if (idx == -1) {
                break;
            }
            
            if (A[i] + B[idx] > curSum) {
                curSum = A[i] + B[idx];
                res[0] = i;
                res[1] = idx;
            }
        }
        
        return res;
    }
    
    private int binarySearch(int[] B, int max) {
        int l = 0, r = B.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (B[m] <= max) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        if (B[l] > max) {
            return -1;
        }
        
        int tmp = B[l];
        r = l;
        l = 0;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (B[m] >= tmp) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().optimalUtilization(new int[]{1, 1, 3, 3, 6, 11, 12, 14, 15, 18}, new int[]{5, 5, 9, 12, 18}, 9)));
    }
}
