public class Solution {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        if (A.length == 1) {
            return A[0];
        }
        
        long[] dp = new long[A.length + 1];
        dp[1] = A[0];
        for (int i = 2; i <= A.length; i++) {
            dp[i] = Math.max(dp[i - 1], A[i - 1] + dp[i - 2]);
        }
        
        return dp[A.length];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().houseRobber(new int[]{5, 2, 1, 3}));
    }
}
