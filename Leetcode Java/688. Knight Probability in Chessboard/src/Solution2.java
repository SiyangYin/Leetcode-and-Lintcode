public class Solution2 {
    public double knightProbability(int N, int K, int r, int c) {
        // dp[s][i][j]走s步，从(i, j)出发的情况下，走到界内的概率
        double[][][] dp = new double[K + 1][N][N];
        
        int[][] dir = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
        dfs(r, c, N, K, dp, dir);
    
        return dp[K][r][c];
    }
    
    // 返回走step步，从(x, y)出发的情况下，走到界内的概率
    private double dfs(int x, int y, int N, int step, double[][][] dp, int[][] dir) {
        if (step == 0) {
            dp[0][x][y] = 1.0;
            return dp[0][x][y];
        }
        
        if (dp[step][x][y] > 0) {
            return dp[step][x][y];
        }
        
        double p = 0.0;
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0], nextY = y + dir[i][1];
            if (inBound(nextX, nextY, N)) {
                p += dfs(nextX, nextY, N, step - 1, dp, dir);
            }
        }
        
        p *= 0.125;
        dp[step][x][y] = p;
        return p;
    }
    
    private boolean inBound(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().knightProbability(4, 10, 0, 0));
        System.out.println(new Solution2().knightProbability(30, 5, 0, 0));
        // System.out.println(new Solution2().knightProbability(1, 0, 0, 0));
    }
}
