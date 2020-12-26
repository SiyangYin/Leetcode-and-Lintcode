import java.util.Arrays;

public class Solution {
    /**
     * @param a: array a
     * @param b: the query array
     * @return: Output an array of length `b.length` to represent the answer
     */
    public int[] minimalDistance(int[] a, int[] b) {
        // Write your code here
        int[] res = new int[b.length];
        
        Arrays.sort(a);
        for (int i = 0; i < b.length; i++) {
            res[i] = binarySearch(a, b[i]);
        }
        
        return res;
    }
    
    private int binarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (a[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        if (l + 1 < a.length && a[l + 1] - target < target - a[l]) {
            return a[l + 1];
        } else {
            return a[l];
        }
    }
}
