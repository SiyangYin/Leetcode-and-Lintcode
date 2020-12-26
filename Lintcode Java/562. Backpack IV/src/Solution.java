public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackIV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i * nums[0] <= target; i++) {
            dp[0][i * nums[0]] = 1;
        }
    
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i][j - nums[i]];
                }
            }
        }
        
        return dp[nums.length - 1][target];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().backPackIV(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Solution().backPackIV(new int[]{2, 3, 4, 5}, 7));
    }
}
