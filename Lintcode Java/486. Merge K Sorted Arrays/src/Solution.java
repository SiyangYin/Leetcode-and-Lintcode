import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        
        return merge(arrays, 0, arrays.length - 1);
    }
    
    private int[] merge(int[][] arrays, int l, int r) {
        if (l == r) {
            return arrays[l];
        }
        
        int m = l + (r - l >> 1);
        int[] a = merge(arrays, l, m), b = merge(arrays, m + 1, r);
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, idx = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[idx++] = a[i++];
            } else {
                res[idx++] = b[j++];
            }
        }
        
        while (i < a.length) {
            res[idx++] = a[i++];
        }
        
        while (j < b.length) {
            res[idx++] = b[j++];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {2, 4, 6}, {0, 8, 9, 10, 11}};
        System.out.println(Arrays.toString(new Solution().mergekSortedArrays(arr)));
    }
}
