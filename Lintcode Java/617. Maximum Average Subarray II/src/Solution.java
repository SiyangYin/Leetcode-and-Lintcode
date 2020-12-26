public class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k:    an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        double l = nums[0], r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        
        double res = l;
        while (l + 1E-6 < r) {
            double m = l + (r - l) / 2.0;
            if (check(nums, k, m)) {
                l = m;
                res = Math.max(res, l);
            } else {
                r = m;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] nums, int k, double avg) {
        double preL = 0, preR = 0, minPreL = 0;
        for (int i = 0; i < k; i++) {
            preR += nums[i] - avg;
        }
        
        for (int i = k; i < nums.length; i++) {
            if (preR - minPreL >= 0) {
                return true;
            }
            
            preR += nums[i] - avg;
            preL += nums[i - k] - avg;
            minPreL = Math.min(minPreL, preL);
        }
        
        return preR >= minPreL;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxAverage(new int[]{1, 12, -5, -6, 50, 3}, 3));
        System.out.println(new Solution().maxAverage(new int[]{1, 4}, 1));
    }
}
