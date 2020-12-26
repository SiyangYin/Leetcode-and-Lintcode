public class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        int[] dp = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            res += dfs(i, dp, ratings);
        }
        
        return res;
    }
    
    private int dfs(int i, int[] dp, int[] ratings) {
        if (dp[i] != 0) {
            return dp[i];
        }
        
        dp[i] = 1;
        if (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
            dp[i] = Math.max(dp[i], 1 + dfs(i + 1, dp, ratings));
        }
        
        if (i - 1 >= 0 && ratings[i] > ratings[i - 1]) {
            dp[i] = Math.max(dp[i], 1 + dfs(i - 1, dp, ratings));
        }
        
        return dp[i];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 2, 2}));
    }
}
