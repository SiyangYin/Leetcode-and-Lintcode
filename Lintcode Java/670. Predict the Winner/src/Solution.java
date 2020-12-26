public class Solution {
    /**
     * @param nums: nums an array of scores
     * @return: check if player 1 will win
     */
    public boolean PredictTheWinner(int[] nums) {
        // write your code here
        int n = nums.length;
        if (n % 2 == 0 || n == 1) {
            return true;
        }
        
        int[][] dp = new int[n][n];
    
        for (int len = 1; len <= nums.length; len++) {
            for (int l = 0; l + len - 1 < nums.length; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    dp[l][r] = nums[l];
                } else {
                    dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1]);
                }
            }
        }
        
        return dp[0][n - 1] >= 0;
    }
}
