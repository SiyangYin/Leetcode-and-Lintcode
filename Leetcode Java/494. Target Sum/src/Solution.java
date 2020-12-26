public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[nums.length][S + 1];
        dp[0][0] = nums[0] == 0 ? 1 : 0;
        
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < S + 1; j++) {
                dp[i][j] =0;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
    
    }
}
