public class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[2][N][N];
        
        dp[0][r][c] = 1;
    
        int[][] dir = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
        
        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[step & 1][i][j] = 0;
                    
                    for (int k = 0; k < dir.length; k++) {
                        int prevX = i + dir[k][0], prevY = j + dir[k][1];
                        if (0 <= prevX && prevX < N && 0 <= prevY && prevY < N) {
                            dp[step & 1][i][j] += dp[step - 1 & 1][prevX][prevY];
                        }
                    }
                    
                    dp[step & 1][i][j] *= 0.125;
                }
            }
        }
    
        double res = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K & 1][i][j];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().knightProbability(3, 2, 0, 0));
    }
}
