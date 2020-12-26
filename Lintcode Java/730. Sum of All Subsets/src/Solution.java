public class Solution {
    /**
     * @param n: the given number
     * @return: Sum of elements in subsets
     */
    public int subSum(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] << 1) + (1 << i - 1) * i;
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subSum(3));
    }
}
