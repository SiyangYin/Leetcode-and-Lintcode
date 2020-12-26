public class Solution {
    /**
     * @param matrix: the matrix in problem
     * @return: the depth of the tunnel.
     */
    public int FindDepth(int[][] matrix) {
        // Write your code here
        int x = 0, y = 0;
        int[] d = {1, 0, -1, 0, 1};
        
        int res = 0;
        while (x != 0 || y != matrix[0].length - 1) {
            res = Math.max(res, x);
            matrix[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = x + d[i], nextY = y + d[i + 1];
                if (inBound(nextX, nextY, matrix) && matrix[nextX][nextY] == 1) {
                    x = nextX;
                    y = nextY;
                    break;
                }
            }
        }
        
        return res;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}};
        System.out.println(new Solution().FindDepth(mat));
    }
}
