public class Solution {
    /**
     * @param nums: a Integer list
     * @return: return the sum of subarrays
     */
    public int SubArraySum(int[] nums) {
        // write your code here
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * (i + 1) * (nums.length - i);
        }
        
        return res;
    }
}
