import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        addOuter(matrix, 0, 0, matrix.length, matrix[0].length, res);
        
        return res;
    }
    
    private void addOuter(int[][] matrix, int x, int y, int m, int n, List<Integer> res) {
        if (m == 0 || n == 0){
            return;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                res.add(matrix[x][y + i]);
            }
            return;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                res.add(matrix[x + i][y]);
            }
            return;
        }
        
        for (int i = 0; i < n - 1; i++) {
            res.add(matrix[x][y + i]);
        }
        for (int i = 0; i < m - 1; i++) {
            res.add(matrix[x + i][y + n - 1]);
        }
        for (int i = n - 1; i > 0; i--) {
            res.add(matrix[x + m - 1][y + i]);
        }
        for (int i = m - 1; i > 0; i--) {
            res.add(matrix[x + i][y]);
        }
        
        addOuter(matrix, x + 1, y + 1, m - 2, n - 2, res);
    }
    
    public static void main(String[] args) {
        // int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution2().spiralOrder(matrix));
    }
}
