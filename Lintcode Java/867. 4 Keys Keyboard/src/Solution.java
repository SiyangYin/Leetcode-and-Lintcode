public class Solution {
    /**
     * @param N: an integer
     * @return: return an integer
     */
    public int maxA(int N) {
        // write your code here
        int[] dp = new int[N + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            int mj = i - 1;
            for (int j = 0; j + 2 <= i; j++) {
                if (dp[i - 2 - j] * (j+1) > dp[i]) {
                    dp[i] = Math.max(dp[i], dp[i - 2 - j] * (j + 1));
                    mj = j;
                }
            }
            System.out.println("dp[" + i + "] = " + dp[i] + "  mj = " + mj);
        }
        
        return dp[N];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().maxA(3));
        // System.out.println(new Solution().maxA(7));
        System.out.println(new Solution().maxA(30));
    }
}
