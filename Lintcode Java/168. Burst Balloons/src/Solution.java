public class Solution {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        
        return dfs(0, len - 1, dp, nums);
    }
    
    private int dfs(int l, int r, int[][] dp, int[] nums) {
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        
        for (int i = l; i <= r; i++) {
            int left = 0, right = 0;
            if (i - 1 >= l) {
                left = dfs(l, i - 1, dp, nums);
            }
            if (i + 1 <= r) {
                right = dfs(i + 1, r, dp, nums);
            }
            
            dp[l][r] = Math.max(dp[l][r], left + right + nums[i] * (l - 1 >= 0 ? nums[l - 1] : 1) * (r + 1 < nums.length ? nums[r + 1] : 1));
        }
        
        return dp[l][r];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{4, 1, 5, 10}));
    }
}
