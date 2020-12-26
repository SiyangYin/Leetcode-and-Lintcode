import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int[] d = {0, 1, 0, -1, 0};
        int x = 0, y = 0;
        int count = 0;
        while (count < m * n) {
            for (int i = 0; i < 4; i++) {
                while (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] != -1) {
                    res.add(matrix[x][y]);
                    count++;
                    matrix[x][y] = -1;
                    
                    x += d[i];
                    y += d[i + 1];
                }
                
                x -= d[i];
                y -= d[i + 1];
                x += d[i + 1];
                y += d[(i + 2) % 4];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] mat = {{6, 4, 1}, {7, 8, 9}};
        // int[][] mat = {};
        System.out.println(new Solution2().spiralOrder(mat));
    }
}
