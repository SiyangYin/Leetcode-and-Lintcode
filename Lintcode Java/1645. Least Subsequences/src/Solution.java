import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param A: The original array.
     * @return: Count the minimum number of subarrays.
     */
    public int LeastSubsequences(List<Integer> A) {
        // Write your code here.
        int[] f = new int[A.size()];
        int idx = 0;
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            int pos = binarySearch(f, idx, x);
            if (pos == -1) {
                f[idx++] = x;
            } else {
                f[pos] = x;
            }
        }
        
        return idx;
    }
    
    private int binarySearch(int[] f, int idx, int t) {
        int l = 0, r = idx - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (f[m] > t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return f[l] > t ? l : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().LeastSubsequences(Arrays.asList(5, 2, 4, 3, 1, 6)));
        System.out.println(new Solution().LeastSubsequences(Arrays.asList(1, 1, 1, 1, 1)));
    }
}
