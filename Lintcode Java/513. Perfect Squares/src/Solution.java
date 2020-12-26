import java.util.Arrays;

public class Solution {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                if (dp[i] <= 2) {
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1000000));
    }
}
