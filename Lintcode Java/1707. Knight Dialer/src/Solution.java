import java.util.Arrays;

public class Solution {
    /**
     * @param N: N
     * @return: return the number of distinct numbers can you dial in this manner mod 1e9+7
     */
    public int knightDialer(int N) {
        // Write your code here
        int MOD = (int) (1E9 + 7);
        int[][] move = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        
        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < N; i++) {
            Arrays.fill(dp[i & 1], 0);
            for (int j = 0; j < 10; j++) {
                for (int prev : move[j]) {
                    dp[i & 1][j] += dp[i - 1 & 1][prev];
                    dp[i & 1][j] %= MOD;
                }
            }
        }
        
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[N - 1 & 1][i];
        }
        
        return (int) (res % (1E9 + 7));
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().knightDialer(1));
        // System.out.println(new Solution().knightDialer(2));
        // System.out.println(new Solution().knightDialer(1111));
        // System.out.println(new Solution().knightDialer(4666));
        System.out.println(new Solution().knightDialer(3));
        System.out.println(new Solution().knightDialer(2));
    }
}
