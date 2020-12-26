import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        
        int[] tmp = new int[len + 2];
        tmp[0] = tmp[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            tmp[i] = nums[i - 1];
        }
        
        nums = tmp;
        
        int[][] dp = new int[len + 2][len + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(1, len, nums, dp);
    }
    
    private int dfs(int l, int r, int[] nums, int[][] dp) {
        if (l > r) {
            return 0;
        }
        
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            dp[l][l] = nums[l - 1] * nums[l] * nums[l + 1];
            return dp[l][l];
        }
        
        int res = 0;
        for (int i = l; i <= r; i++) {
            int left = dfs(l, i - 1, nums, dp), right = dfs(i + 1, r, nums, dp);
            res = Math.max(res, left + right + nums[i] * nums[l - 1] * nums[r + 1]);
        }
        
        dp[l][r] = res;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
