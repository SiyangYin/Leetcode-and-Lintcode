public class Solution3 {
    
    public static void main(String[] args) {
        System.out.println(new Solution3().canPartition(new int[]{1, 2, 5}));
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int half = sum / 2;
        if (half * 2 != sum) {
            return false;
        }
        
        boolean[] dp = new boolean[half + 1];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] = j == nums[i] | dp[j] | dp[j - nums[i]];
            }
        }
        
        return dp[half];
    }
}
