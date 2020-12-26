public class Solution {
    /**
     * @param nums: a non-empty array only positive integers
     * @return: true if can partition or false
     */
    public boolean canPartition(int[] nums) {
        // write your code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        if (nums[0] <= sum) {
            dp[0][0] = dp[0][nums[0]] = true;
        } else {
            return false;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
                
                if (dp[i][sum]) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 4, 5, 6, 1, 2, 4, 1, 3, 4, 1, 2, 4, 5, 1, 91, 4, 5, 6, 1, 2, 4, 1, 3, 4, 1, 2, 4, 5, 1};
        System.out.println(new Solution().canPartition(A));
    }
}
