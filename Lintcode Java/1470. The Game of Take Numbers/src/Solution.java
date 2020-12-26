public class Solution {
    /**
     * @param A: the array
     * @return: the winner
     */
    public int theGameOfTakeNumbers(int[] A) {
        // Write your code here
        if (A.length % 2 == 0) {
            return 1;
        }
        
        int[][] dp = new int[A.length][A.length];
        for (int len = 1; len <= A.length; len++) {
            for (int l = 0; l + len - 1 < A.length; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    dp[l][r] = A[l];
                } else {
                    dp[l][r] = Math.max(A[l] - dp[l + 1][r], A[r] - dp[l][r - 1]);
                }
            }
        }
        
        return dp[0][A.length - 1] >= 0 ? 1 : 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().theGameOfTakeNumbers(new int[]{1, 3, 1, 1}));
    }
}
