public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        int[] dp = new int[Math.max(3, n + 1)];
        dp[0] = 1;
        dp[1] = k;
        dp[2] = k * k;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
        System.out.println(new Solution().numWays(1, 1));
        System.out.println(new Solution().numWays(2, 2));
    
        System.out.println(new Solution().v(2, 2));
    }
    
    public int v(int n, int k) {
        int dp[] = {0, k , k*k, 0};
        if(n <= 2)
            return dp[n];
        if (k == 1)
            return 0;
        for(int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}
