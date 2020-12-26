public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = dp[i - 1];
            if (i > 1) {
                dp[i] = Math.max(dp[i], nums[i] + dp[i - 2]);
            }
            
            res = Math.max(res, dp[i]);
        }
        
        dp[0] = 0;
        dp[1] = nums[1];
        res = Math.max(res, dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().houseRobber2(new int[]{3, 6, 4}));
    }
}
