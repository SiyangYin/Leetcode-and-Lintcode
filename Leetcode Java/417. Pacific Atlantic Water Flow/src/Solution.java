import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] canflow = new int[m][n];
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, visited, canflow, d, 1);
        }
    
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, visited, canflow, d, 1);
        }
    
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, n - 1, visited, canflow, d, 2);
        }
    
        for (int j = 0; j < n; j++) {
            dfs(matrix, m - 1, j, visited, canflow, d, 2);
        }
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canflow[i][j] == 3) {
                    res.add(Arrays.asList(i ,j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, int x, int y, boolean[][] visited,
                     int[][] canflow, int[][] d, int ocean) {
        visited[x][y] = true;
        if (canflow[x][y] == 1 && ocean == 2) {
            canflow[x][y] = 3;
        } else if (canflow[x][y] == 0) {
            canflow[x][y] = ocean;
        }
        
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
                && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y]) {
                dfs(matrix, newX, newY, visited, canflow, d, ocean);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}};
        
        matrix = new int[][]{{1}};
        System.out.println(new Solution().pacificAtlantic(matrix));
    }
}
