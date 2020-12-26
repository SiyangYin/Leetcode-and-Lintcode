import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int[] mins = new int[matrix.length], maxs = new int[matrix[0].length];
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        
        int s = 0, t = 0;
        while (s < matrix.length || t < matrix[0].length) {
            if (s < matrix.length) {
                for (int i = 0; i < matrix[0].length; i++) {
                    mins[s] = Math.min(mins[s], matrix[s][i]);
                }
                s++;
            }
            if (t < matrix[0].length) {
                for (int i = 0; i < matrix.length; i++) {
                    maxs[t] = Math.max(maxs[t], matrix[i][t]);
                }
                t++;
            }
        }
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == mins[i] && matrix[i][j] == maxs[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        
        return res;
    }
}
