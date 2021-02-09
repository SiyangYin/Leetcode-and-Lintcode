public class Solution {
    /**
     * @param A: an array
     * @param B: an array
     * @return: the minimum number of swaps to make both sequences strictly increasing
     */
    public int minSwap(int[] A, int[] B) {
        // Write your code here
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                } else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }
}
