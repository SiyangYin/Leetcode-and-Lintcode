public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] dp = {1, 1};
        
        int res = 1;
        for (int i = 1; i < A.length; i++) {
            dp[0] = A[i] > A[i - 1] ? dp[0] + 1 : 1;
            dp[1] = A[i] < A[i - 1] ? dp[1] + 1 : 1;
            
            res = Math.max(res, dp[0]);
            res = Math.max(res, dp[1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
    }
}
