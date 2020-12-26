import java.util.Arrays;

public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLIS(
                new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(new Solution2().lengthOfLIS(new int[]{}));
    }
}