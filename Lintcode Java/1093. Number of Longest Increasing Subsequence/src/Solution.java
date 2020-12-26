public class Solution {
    /**
     * @param nums: an array
     * @return: the number of longest increasing subsequence
     */
    public int findNumberOfLIS(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        
        int globalMaxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxLen = 0, maxCount = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j][0] > maxLen) {
                        maxLen = dp[j][0];
                        maxCount = dp[j][1];
                    } else if (dp[j][0] == maxLen) {
                        maxCount += dp[j][1];
                    }
                }
            }
            
            dp[i][0] = maxLen + 1;
            dp[i][1] = Math.max(1, maxCount);
            
            globalMaxLen = Math.max(globalMaxLen, dp[i][0]);
        }
        
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == globalMaxLen) {
                res += dp[i][1];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}
