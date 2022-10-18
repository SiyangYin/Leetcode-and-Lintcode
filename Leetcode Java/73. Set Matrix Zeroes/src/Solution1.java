import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowNum = new HashSet<>();
        Set<Integer> colNum = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowNum.add(i);
                    colNum.add(j);
                }
            }
        }
        for (int i : rowNum) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : colNum) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
