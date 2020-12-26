import java.util.Arrays;

public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
        
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().longestIncreasingSubsequence(new int[]{88, 4, 24, 82, 86, 1, 56, 74, 71, 9, 8, 18, 26, 53, 77, 87, 60, 27, 69, 17, 76, 23, 67, 14, 98, 13, 10, 83, 20, 43, 39, 29, 92, 31, 0, 30, 90, 70, 37, 59}));
        System.out.println(new Solution().longestIncreasingSubsequence(new int[]{5, 4, 1, 2, 3}));
    }
}