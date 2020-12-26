import java.util.Arrays;

public class Solution {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        
        int n = matrix.length, m = matrix[0].length;
        int[] res = new int[n * m];
        int idx = 0, x = 0, y = 0;
        while (idx < n * m) {
            while (x >= 0 && y < m) {
                res[idx++] = matrix[x][y];
                x--;
                y++;
            }
            x++;
            y--;
            
            if (y + 1 < m) {
                y++;
            } else {
                x++;
            }
            
            while (x < n && y >= 0) {
                res[idx++] = matrix[x][y];
                x++;
                y--;
            }
            x--;
            y++;
            
            if (x + 1 < n) {
                x++;
            } else {
                y++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(new Solution().printZMatrix(matrix)));
    }
}
