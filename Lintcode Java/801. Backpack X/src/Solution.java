public class Solution {
    /**
     * @param n: the money you have
     * @return: the minimum money you have to give
     */
    public int backPackX(int n) {
        // write your code here
        int[] A = {150, 250, 350};
        
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j < A.length; j++) {
                if (i >= A[j]) {
                    dp[i] = Math.min(dp[i], dp[i - A[j]]);
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().backPackX(9113));
    }
}
