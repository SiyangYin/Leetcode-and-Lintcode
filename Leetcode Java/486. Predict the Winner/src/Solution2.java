public class Solution2 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
    
        System.out.println(dp[nums.length - 1]);
        
        return dp[nums.length - 1] >= 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().PredictTheWinner(new int[]{0, 0, 6, 5, 6, 7}));
    }
}
