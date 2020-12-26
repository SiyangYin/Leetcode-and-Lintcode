public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(solve(nums, 0, nums.length - 2), solve(nums, 1, nums.length - 1));
    }
    
    private int solve(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        for (int i = start; i <= end; i++) {
            if (i == start) {
                dp[i] = nums[i];
            } else if (i == start + 1) {
                dp[i] = Math.max(nums[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
        }
        
        return dp[end];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
        System.out.println(new Solution().rob(new int[]{2}));
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}
