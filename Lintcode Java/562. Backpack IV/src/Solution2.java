public class Solution2 {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackIV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[target + 1];
        for (int i = 0; i * nums[0] <= target; i++) {
            dp[i * nums[0]] = 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        
        return dp[target];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().backPackIV(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Solution2().backPackIV(new int[]{2, 3, 4, 5}, 7));
    }
}
