import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        
        int[] d = {0, 1, 0, -1, 0};
        int x = 0, y = 0, count = 0;
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
        System.out.println(new Solution().spiralOrder(mat));
    }
}
