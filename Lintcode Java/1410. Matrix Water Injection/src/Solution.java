public class Solution {
    /**
     * @param matrix: the height matrix
     * @param R: the row of (R,C)
     * @param C: the columns of (R,C)
     * @return: Whether the water can flow outside
     */
    public String waterInjection(int[][] matrix, int R, int C) {
        // Write your code here
        return dfs(R, C, matrix) ? "YES" : "NO";
    }
    
    private boolean dfs(int x, int y, int[][] matrix) {
        if (x == 0 || x == matrix.length - 1 || y == 0 || y == matrix[0].length - 1) {
            return true;
        }
        
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < matrix.length && 0 <= nextY && nextY < matrix[0].length && matrix[nextX][nextY] < matrix[x][y]) {
                if (dfs(nextX, nextY, matrix)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
