import java.util.Arrays;

public class Solution {
    public int knightDialer(int n) {
        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        
        int[][] move = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int MOD = (int) (1E9 + 7);
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i & 1][j] = 0;
                for (int prev : move[j]) {
                    dp[i & 1][j] += dp[i - 1 & 1][prev];
                    dp[i & 1][j] %= MOD;
                }
            }
        }
        
        int res = 0;
        for (int count : dp[n - 1 & 1]) {
            res += count;
            res %= MOD;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().knightDialer(2));
        System.out.println(new Solution().knightDialer(3));
    }
}
