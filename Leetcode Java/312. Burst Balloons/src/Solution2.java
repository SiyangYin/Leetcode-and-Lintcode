public class Solution2 {
    public int maxCoins(int[] nums) {
        int size = nums.length;
    
        int[] tmp = new int[size + 2];
        tmp[0] = tmp[size + 1] = 1;
        for (int i = 1; i <= size; i++) {
            tmp[i] = nums[i - 1];
        }
        nums = tmp;
        
        int[][] dp = new int[size + 2][size + 2];
    
        for (int len = 1; len <= size; len++) {
            for (int i = 1; i + len - 1 <= size; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = nums[i] * nums[i - 1] * nums[i + 1];
                } else {
                    for (int k = i; k <= j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1]);
                    }
                }
            }
        }
        
        return dp[1][size];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
