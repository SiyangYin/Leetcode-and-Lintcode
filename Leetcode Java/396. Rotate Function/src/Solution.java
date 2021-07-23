public class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, x = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            x += i * nums[i];
        }
        
        int res = x;
        for (int i = nums.length - 1; i >= 1; i--) {
            x = x + sum - nums.length * nums[i];
            res = Math.max(res, x);
        }
        
        return res;
    }
}
