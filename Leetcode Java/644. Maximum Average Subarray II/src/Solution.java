public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double l, r;
        l = r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        
        double eps = 1E-5;
        while (l + eps < r) {
            double m = l + (r - l) / 2;
            if (check(nums, m, k)) {
                l = m;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    private boolean check(int[] A, double t, int k) {
        double cur = 0, prev = 0;
        for (int i = 0; i < k; i++) {
            cur += A[i] - t;
        }
        
        if (cur >= 0) {
            return true;
        }
        
        double min = 0;
        for (int i = k; i < A.length; i++) {
            cur += A[i] - t;
            prev += A[i - k] - t;
            min = Math.min(min, prev);
            
            if (cur - min >= 0) {
                return true;
            }
        }
        
        return false;
    }
}
