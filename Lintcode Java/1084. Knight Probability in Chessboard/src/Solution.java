import java.util.Arrays;

public class Solution {
    /**
     * @param N: int
     * @param K: int
     * @param r: int
     * @param c: int
     * @return: the probability
     */
    public double knightProbability(int N, int K, int r, int c) {
        // Write your code here.
        double[][][] dp = new double[N][N][K];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(r, c, N, 0, K, dp);
    }
    
    private double dfs(int x, int y, int N, int step, int K, double[][][] dp) {
        if (outBound(x, y, N)) {
            return 0.0;
        }
        
        if (step == K) {
            return 1;
        }
        
        if (dp[x][y][step] >= 0) {
            return dp[x][y][step];
        }
        
        int[] dx = {1, 2, 1, 2, -1, -2, -1, -2}, dy = {2, 1, -2, -1, 2, 1, -2, -1};
        double prob = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            prob += 0.125 * dfs(nextX, nextY, N, step + 1, K, dp);
        }
        
        dp[x][y][step] = prob;
        return prob;
    }
    
    private boolean outBound(int x, int y, int N) {
        return !(0 <= x && x < N && 0 <= y && y < N);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().knightProbability(3, 2, 0, 0));
    }
}
