public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        if (obstacleGrid[0][0] != 1) res[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    res[i][j] += res[i - 1][j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    res[i][j] += res[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1] != 1 ? res[m - 1][n - 1] : 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().uniquePathsWithObstacles(new int[][]
                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
