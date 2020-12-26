public class Solution3 {
    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = (int) (1E9 + 7);
        
        // dp[s][i][j]表示从(i, j)走s步走出界的路径总数
        int[][][] dp = new int[2][m][n];
    
        int[] dir = {1, 0, -1, 0, 1};
        for (int k = 1; k <= N; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    dp[k & 1][x][y] = 0;
                    
                    for (int p = 0; p < 4; p++) {
                        int nextX = x + dir[p], nextY = y + dir[p + 1];
                        dp[k & 1][x][y] += inBound(nextX, nextY, m, n) ? dp[k - 1 & 1][nextX][nextY] : 1;
                        dp[k & 1][x][y] %= MOD;
                    }
                }
            }
        }
        
        return dp[N & 1][i][j];
    }
    
    private boolean inBound(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
}
