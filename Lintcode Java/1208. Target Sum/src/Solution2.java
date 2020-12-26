public class Solution2 {
    /**
     * @param nums: the given array
     * @param s: the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    public int findTargetSumWays(int[] nums, int s) {
        // Write your code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum < s) {
            return 0;
        }
        
        int[][] dp = new int[nums.length + 1][(sum << 1) + 1];
        dp[0][sum] = 1;
    
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum << 1; j++) {
                if (j - nums[i] >= 0) {
                    dp[i + 1][j] += dp[i][j - nums[i]];
                }
                if (j + nums[i] <= sum << 1) {
                    dp[i + 1][j] += dp[i][j + nums[i]];
                }
            }
        }
        
        return dp[nums.length][sum + s];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
