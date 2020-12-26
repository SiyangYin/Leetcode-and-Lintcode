import java.util.Arrays;

public class Solution {
    
    private int MOD = (int) (1E9 + 7);
    
    /**
     * @param m: an integer
     * @param n: an integer
     * @param N: an integer
     * @param i: an integer
     * @param j: an integer
     * @return: the number of paths to move the ball out of grid boundary
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        // Write your code here
        long[][][] dp = new long[m][n][N];
        for (int k = 0; k < dp.length; k++) {
            for (int l = 0; l < dp[0].length; l++) {
                Arrays.fill(dp[k][l], -1);
            }
        }
        
        return (int) (dfs(i, j, m, n, 0, N, dp) % MOD);
    }
    
    private long dfs(int x, int y, int m, int n, int step, int N, long[][][] dp) {
        if (outBound(x, y, m, n)) {
            return 1;
        }
        
        if (step == N) {
            return 0;
        }
        
        if (dp[x][y][step] != -1) {
            return dp[x][y][step];
        }
        
        long res = 0;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            res += dfs(nextX, nextY, m, n, step + 1, N, dp) % MOD;
        }
        
        dp[x][y][step] = res;
        return res;
    }
    
    private boolean outBound(int x, int y, int m, int n) {
        return !(0 <= x && x < m && 0 <= y && y < n);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().findPaths(1, 3, 3, 0, 1));
        // System.out.println(new Solution().findPaths(2, 3, 8, 1, 0));
        System.out.println(new Solution().findPaths(28, 9, 35, 3, 4));
    }
}
