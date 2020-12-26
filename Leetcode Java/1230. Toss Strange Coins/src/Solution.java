public class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int len = prob.length;
        double[][] dp = new double[len][target + 1];
        
        dp[0][0] = 1 - prob[0];
        if (target >= 1) {
            dp[0][1] = prob[0];
        }
    
        for (int i = 1; i < prob.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] * (1 - prob[i]);
                } else {
                    dp[i][j] = dp[i - 1][j] * (1 - prob[i]) + dp[i - 1][j - 1] * prob[i];
                }
            }
        }
        
        return dp[len - 1][target];
    }
}
