public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int half = sum / 2;
        if (half * 2 != sum) {
            return false;
        }
        
        // dp[i][j] 表示nums里前i + 1项中是否存在若干项的和等于j
        boolean[][] dp = new boolean[nums.length][half + 1];
        if (nums[0] <= half) {
            dp[0][nums[0]] = true;
        }
    
        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i]; j <= half; j++) {
                dp[i][j] = nums[i] == j | dp[i - 1][j] | dp[i - 1][j - nums[i]];
            }
        }
        
        return dp[nums.length - 1][half];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 2, 3, 5}));
    }
}
