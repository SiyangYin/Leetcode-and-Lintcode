import java.util.Arrays;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
    
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(10));
    }
}
