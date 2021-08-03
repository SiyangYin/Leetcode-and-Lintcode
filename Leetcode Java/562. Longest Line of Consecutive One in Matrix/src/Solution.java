public class Solution {
    public int longestLine(int[][] mat) {
        int res = 0, m = mat.length, n = mat[0].length;
        int[][][] f = new int[4][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                
                f[0][i][j] = j == 0 ? 1 : 1 + f[0][i][j - 1];
                f[1][i][j] = i == 0 ? 1 : 1 + f[1][i - 1][j];
                f[2][i][j] = i >= 1 && j >= 1 ? 1 + f[2][i - 1][j - 1] : 1;
                f[3][i][j] = i >= 1 && j < n - 1 ? 1 + f[3][i - 1][j + 1] : 1;
                for (int[][] g : f) {
                    res = Math.max(res, g[i][j]);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};
        System.out.println(new Solution().longestLine(mat));
    }
}
