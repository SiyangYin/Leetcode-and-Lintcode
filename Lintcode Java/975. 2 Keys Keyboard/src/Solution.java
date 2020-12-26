public class Solution {
    /**
     * @param n: The number of 'A'
     * @return: the minimum number of steps to get n 'A'
     */
    public int minSteps(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
    
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i >> 1; j >= 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSteps(24));
    }
}
