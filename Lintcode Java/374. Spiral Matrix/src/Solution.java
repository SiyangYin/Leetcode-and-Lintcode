import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int left, right, bottom, top;
        left = 0; right = matrix[0].length - 1;
        bottom = matrix.length - 1; top = 0;
        int steps = 0;
        while (left <= right && top <= bottom && steps <= matrix.length * matrix[0].length) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
                steps++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
                steps++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
                steps++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
                steps++;
            }
            left++;
        }
        return list.subList(0, matrix.length * matrix[0].length);
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        System.out.println(new Solution().spiralOrder(matrix));
        
        int[][] matrix1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        System.out.println(new Solution().spiralOrder(matrix1));
    }
}