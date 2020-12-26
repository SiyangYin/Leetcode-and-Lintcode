public class Solution {
    /**
     * @param p:    The time you choose to do part of the problem.
     * @param part: The points you choose to do part of the problem.
     * @param f:    The time you choose to do the whole problem.
     * @param full: The points you choose to do the whole problem.
     * @return: Return the maximum number of points you can get.
     */
    public int exam(int[] p, int[] part, int[] f, int[] full) {
        // write your code here
        int n = p.length;
        int[][] dp = new int[n][121];
        for (int i = p[0]; i <= 120; i++) {
            dp[0][i] = part[0];
            if (i >= f[0]) {
                dp[0][i] = full[0];
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 120; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= p[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - p[i]] + part[i]);
                }
                if (j >= f[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - f[i]] + full[i]);
                }
            }
        }
        
        return dp[n - 1][120];
    }
    
    public static void main(String[] args) {
        int[] p = {20, 50, 100, 5}, part = {20, 30, 60, 3}, f = {100, 80, 110, 10}, full = {60, 55, 88, 6};
        System.out.println(new Solution().exam(p, part, f, full));
    }
}
