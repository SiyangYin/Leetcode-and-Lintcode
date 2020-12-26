import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] upleft = new boolean[m][n], downright = new boolean[m][n];
        
        for (int i = 0; i < n; i++) {
            if (!upleft[0][i]) {
                dfs(0, i, matrix,  upleft);
            }
            if (!downright[m - 1][i]) {
                dfs(m - 1, i, matrix, downright);
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (!upleft[i][0]) {
                dfs(i, 0, matrix, upleft);
            }
            if (!downright[i][n - 1]) {
                dfs(i, n - 1, matrix, downright);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (upleft[i][j] && downright[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int x, int y, int[][] matrix, boolean[][] mark) {
        mark[x][y] = true;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < matrix.length && 0 <= nextY && nextY < matrix[0].length && !mark[nextX][nextY] && matrix[x][y] <= matrix[nextX][nextY]) {
                dfs(nextX, nextY, matrix, mark);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        System.out.println(new Solution().pacificAtlantic(mat));
    }
}
