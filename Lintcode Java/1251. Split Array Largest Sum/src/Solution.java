public class Solution {
    /**
     * @param nums: a list of integers
     * @param m:    an integer
     * @return: return a integer
     */
    public int splitArray(int[] nums, int m) {
        // write your code here
        int[][] dp = new int[m + 1][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[1][i] += (i == 0 ? nums[0] : nums[i] + dp[1][i - 1]);
        }
        
        for (int i = 2; i <= m; i++) {
            for (int j = i - 1; j < nums.length; j++) {
                int sum = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i - 1; k--) {
                    sum += nums[k];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k - 1], sum));
                    if (sum >= dp[i - 1][k - 1]) {
                        break;
                    }
                }
            }
        }
        
        return dp[m][nums.length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(new Solution().splitArray(new int[]{1,4,4}, 3));
    }
}
