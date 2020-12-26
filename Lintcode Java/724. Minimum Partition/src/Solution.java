public class Solution {
    /**
     * @param nums: the given array
     * @return: the minimum difference between their sums
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        boolean[][] dp = new boolean[2][sum + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
    
        int res = Math.abs(sum - nums[0] - nums[0]);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i & 1][j] = dp[i - 1 & 1][j];
                if (j >= nums[i]) {
                    dp[i & 1][j] |= dp[i - 1 & 1][j - nums[i]];
                }
    
                if (dp[i & 1][j]) {
                    res = Math.min(res, Math.abs(sum - j - j));
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{1, 2, 3, 4}));
    }
}
