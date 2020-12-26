public class Solution2 {
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
        int cur = 0;
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int last = findFirstLargerOrEqual(dp, cur, nums[i]);
            if (last != -1) {
                dp[last] = nums[i];
            } else if (nums[i] > dp[cur]) {
                dp[++cur] = nums[i];
            }
        }
        
        return cur + 1;
    }
    
    private int findFirstLargerOrEqual(int[] f, int r, int num) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (f[m] < num) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        if (f[l] > num) {
            return l;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().longestIncreasingSubsequence(new int[]{88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59}));
    }
}
