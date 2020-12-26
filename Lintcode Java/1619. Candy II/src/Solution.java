import java.util.Arrays;

public class Solution {
    /**
     * @param ratings: rating value of each child
     * @return: Return the minimum candies you must give.
     */
    
    // 不对
    public int candyII(int[] ratings) {
        // Write your code here
        int[] dp = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            dfs(i, dp, ratings);
        }
        
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] == ratings[i + 1]) {
                int max = dp[i], j = i + 1;
                while (j < ratings.length && ratings[i] == ratings[j]) {
                    max = Math.max(max, dp[j]);
                    j++;
                }
                Arrays.fill(dp, i, j, max);
                
                i = j - 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }
        
        return res;
    }
    
    private int dfs(int i, int[] dp, int[] ratings) {
        if (dp[i] != 0) {
            return dp[i];
        }
        
        int len = 1;
        if (i > 0 && ratings[i] > ratings[i - 1]) {
            len = Math.max(len, 1 + dfs(i - 1, dp, ratings));
        }
        
        if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
            len = Math.max(len, 1 + dfs(i + 1, dp, ratings));
        }
        
        dp[i] = len;
        return len;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().candyII(new int[]{4, 7, 8, 1, 6, 6, 2}));
        // System.out.println(new Solution().candyII(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2}));
        System.out.println(new Solution().candyII(new int[]{10, 10, 10, 10, 2, 1}));
    }
}
