public class Solution2 {
    /**
     * @param N: int
     * @param K: int
     * @param r: int
     * @param c: int
     * @return: the probability
     */
    public double knightProbability(int N, int K, int r, int c) {
        // Write your code here.
        double[][][] dp = new double[N][N][K + 1];
        dp[r][c][0] = 1.0;
    
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] dx = {1, 2, 1, 2, -1, -2, -1, -2}, dy = {2, 1, -2, -1, 2, 1, -2, -1};
                    for (int l = 0; l < 8; l++) {
                        int prevX = i + dx[l], prevY = j + dy[l];
                        if (0 <= prevX && prevX < N && 0 <= prevY && prevY < N) {
                            dp[i][j][k] += 0.125 * dp[prevX][prevY][k - 1];
                        }
                    }
                }
            }
        }
    
        double res = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[i][j][K];
            }
        }
        
        return res;
    }
}
