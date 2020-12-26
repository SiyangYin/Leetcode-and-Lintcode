import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int left, right, bottom, top;
        left = 0; right = matrix[0].length - 1;
        bottom = matrix.length - 1; top = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        while (list.size() > matrix.length * matrix[0].length) {
            list.remove(list.size() - 1);
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        for (int i = 1; i <= 12; i++) {
            matrix[(i - 1) / 4][(i - 1) % 4] = i;
        }
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    
        System.out.println(new Solution().spiralOrder(matrix));
        
        int[][] matrix1 = new int[1][1];
        matrix1[0][0] = 1;
        System.out.println(new Solution().spiralOrder(matrix1));
        
        int[][] matrix2 = new int[2][1];
        matrix2[0][0] = 3;
        matrix2[1][0] = 2;
        System.out.println(new Solution().spiralOrder(matrix2));
    }
}
