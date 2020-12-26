public class Solution {
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
        
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < 2; i++) {
            if (i * nums[0] <= target) {
                dp[0][i * nums[0]] = 1;
            }
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        
        return dp[nums.length - 1][target];
    }
}
