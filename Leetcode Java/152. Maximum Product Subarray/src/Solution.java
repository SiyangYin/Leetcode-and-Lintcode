public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMin = new int[n], dpMax = new int[n];
        
        int res = dpMin[0] = dpMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int prod1 = dpMin[i - 1] * nums[i];
            int prod2 = dpMax[i - 1] * nums[i];
            dpMin[i] = Math.min(nums[i], Math.min(prod1, prod2));
            dpMax[i] = Math.max(nums[i], Math.max(prod1, prod2));
            
            res = Math.max(res, dpMax[i]);
        }
        
        return res;
    }
}
