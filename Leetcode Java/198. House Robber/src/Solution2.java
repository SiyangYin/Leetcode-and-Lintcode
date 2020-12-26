public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        
        return dp[nums.length];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().rob(new int[]{1, 2, 3, 1}));
    }
}
