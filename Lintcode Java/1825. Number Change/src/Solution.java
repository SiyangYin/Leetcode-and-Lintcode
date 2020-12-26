public class Solution {
    /**
     * @param k: integer k
     * @return: minimum number of operations that change 0 to k
     */
    public int numberChange(int k) {
        // write your code here
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            }
        }
        
        return dp[k];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numberChange(4));
    }
}
