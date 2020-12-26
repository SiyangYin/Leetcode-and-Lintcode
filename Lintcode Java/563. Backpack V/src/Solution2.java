public class Solution2 {
    /**
     * @param nums:   an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[target + 1];
        for (int i = 0; i < 2; i++) {
            if (i * nums[0] <= target) {
                dp[i * nums[0]] = 1;
            }
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        
        return dp[target];
    }
}
