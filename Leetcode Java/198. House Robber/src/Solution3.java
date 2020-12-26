public class Solution3 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[3];
        int ind = 1;
        
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ind = (ind + 1) % 3;
            dp[ind] = Math.max(dp[(ind + 1) % 3] + nums[i], dp[(ind + 2) % 3]);
        }
        
        return dp[ind];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().rob(new int[]{1, 2, 3, 1}));
    }
}
