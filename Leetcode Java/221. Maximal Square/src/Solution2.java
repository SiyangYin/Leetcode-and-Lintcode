public class Solution2 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = matrix[0][i] - '0';
            if (dp[i] == 1) {
                res = 1;
            }
        }
    
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[j] = 0;
                    continue;
                }
                
                if (j == 0) {
                    dp[j] = matrix[i][j] - '0';
                } else {
                    if (dp[j] != dp[j - 1]) {
                        dp[j] = Math.min(dp[j - 1], dp[j]) + 1;
                    } else {
                        dp[j] += matrix[i - dp[j]][j - dp[j]] - '0';
                    }
                }
                
                res = Math.max(res, dp[j]);
            }
        }
        
        return res * res;
    }
}
