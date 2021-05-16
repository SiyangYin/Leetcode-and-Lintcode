public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        int[] cost0 = new int[len], cost1 = new int[len];
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    cost0[i]++;
                } else {
                    cost1[i]++;
                }
            }
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = m; j >= cost0[i - 1]; j--) {
                for (int k = n; k >= cost1[i - 1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - cost0[i - 1]][k - cost1[i - 1]]);
                }
            }
        }
        
        return dp[m][n];
    }
}
