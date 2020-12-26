import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
    
    public int uniquePaths2(int m, int n) {
        int k = Math.max(m, n) - 1;
        int l = Math.min(m, n) - 1;
        long product = 1L;
        for (int i = k + l; i > k; i--) {
            product *= i;
        }
        for (int i = 2; i <= l; i++) {
            product /= i;
        }
        return (int)product;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}