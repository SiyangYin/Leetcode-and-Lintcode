import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
    
        int n = matrix.length, m = matrix[0].length;
        
        int[] res = new int[n * m];
        int idx = 0;
        boolean reversed = true;
        for (int i = 0; i < m; i++) {
            List<Integer> diag = new ArrayList<>();
            int x = 0, y = i;
            while (x < n && y >= 0) {
                diag.add(matrix[x][y]);
                x++;
                y--;
            }
            
            if (!reversed) {
                for (int j = 0; j < diag.size(); j++) {
                    res[idx++] = diag.get(j);
                }
            } else {
                for (int j = diag.size() - 1; j >= 0; j--) {
                    res[idx++] = diag.get(j);
                }
            }
            
            reversed = !reversed;
        }
    
        for (int i = 1; i < n; i++) {
            List<Integer> diag = new ArrayList<>();
            int x = i, y = m - 1;
            while (x < n && y >= 0) {
                diag.add(matrix[x][y]);
                x++;
                y--;
            }
    
            if (!reversed) {
                for (int j = 0; j < diag.size(); j++) {
                    res[idx++] = diag.get(j);
                }
            } else {
                for (int j = diag.size() - 1; j >= 0; j--) {
                    res[idx++] = diag.get(j);
                }
            }
            
            reversed = !reversed;
        }
        
        return res;
    }
}
