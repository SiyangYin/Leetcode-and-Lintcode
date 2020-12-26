public class Solution {
    /**
     * @param nums: an array of integer
     * @param k: an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // write your code here
        if (nums.length < k) {
            return 0;
        }
        
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        int res = Integer.MIN_VALUE, curMin = Integer.MAX_VALUE;
        for (int i = k; i <= nums.length; i++) {
            curMin = Math.min(curMin, preSum[i - k]);
            res = Math.max(res, preSum[i] - curMin);
        }
        
        return res;
    }
}
