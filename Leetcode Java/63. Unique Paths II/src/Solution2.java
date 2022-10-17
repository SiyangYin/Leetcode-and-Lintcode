public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return obstacleGrid[m - 1][n - 1] != 1 ? dp(obstacleGrid, new int[m][n], m - 1, n - 1) : 0;
    }

    public int dp(int[][] obstacleGrid, int[][] res, int i, int j) {
        if (res[i][j] != 0) return res[i][j];
        if (i == 0 && j == 0 && obstacleGrid[0][0] != 1) {
            res[0][0] = 1;
            return res[0][0];
        }
        if (i > 0 && obstacleGrid[i - 1][j] != 1) {
            res[i][j] += dp(obstacleGrid, res, i - 1, j);
        }
        if (j > 0 && obstacleGrid[i][j - 1] != 1) {
            res[i][j] += dp(obstacleGrid, res, i, j - 1);
        }
        return res[i][j];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePathsWithObstacles(new int[][]
                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
