import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        long[] h1 = new long[m + 1], h2 = new long[n + 1];
        long P = 131L;
        long[] pow = new long[n + 1];
        pow[0] = 1L;
        
        for (int i = 0; i < m; i++) {
            h1[i + 1] = h1[i] * P + nums1[i];
        }
        for (int i = 0; i < n; i++) {
            h2[i + 1] = h2[i] * P + nums2[i];
            pow[i + 1] = pow[i] * P;
        }
        
        int l = 0, r = Math.min(n, m);
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(mid, nums1, nums2, h1, h2, pow)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
    private boolean check(int len, int[] nums1, int[] nums2, long[] h1, long[] h2, long[] pow) {
        Set<Long> set = new HashSet<>();
        for (int i = len - 1; i < nums1.length; i++) {
            set.add(hash(h1, i - len + 1, i, pow));
        }
        
        for (int i = len - 1; i < nums2.length; i++) {
            if (set.contains(hash(h2, i - len + 1, i, pow))) {
                return true;
            }
        }
        
        return false;
    }
    
    private long hash(long[] ha, int l, int r, long[] pow) {
        return ha[r + 1] - ha[l] * pow[r - l + 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
