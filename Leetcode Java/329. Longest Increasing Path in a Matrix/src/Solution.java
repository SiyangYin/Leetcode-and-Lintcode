public class Solution {
    
    private int longestPath = 0;
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int[][] pathLen = new int[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, pathLen, dirs);
            }
        }
        
        return longestPath;
    }
    
    private int dfs(int[][] matrix, int x, int y, int[][] pathLen, int[][] dirs) {
        if (pathLen[x][y] != 0) {
            return pathLen[x][y];
        }
        
        int res = 1, path = 0;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (inBound(matrix, nextX, nextY) && matrix[nextX][nextY] > matrix[x][y]) {
                path = 1 + dfs(matrix, nextX, nextY, pathLen, dirs);
            }
            
            res = Math.max(res, path);
        }
        
        pathLen[x][y] = res;
        longestPath = Math.max(longestPath, res);
        return res;
    }
    
    private boolean inBound(int[][] matrix, int x, int y) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
}
