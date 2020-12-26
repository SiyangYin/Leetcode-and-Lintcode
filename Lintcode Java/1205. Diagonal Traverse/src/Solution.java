import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param matrix: a 2D array
     * @return: return a list of integers
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int x = i, y = 0;
            lists.add(new ArrayList<>());
            while (inBound(x, y, matrix)) {
                lists.get(lists.size() - 1).add(matrix[x][y]);
                x--;
                y++;
            }
        }
    
        for (int i = 1; i < matrix[0].length; i++) {
            int x = matrix.length - 1, y = i;
            lists.add(new ArrayList<>());
            while (inBound(x, y, matrix)) {
                lists.get(lists.size() - 1).add(matrix[x][y]);
                x--;
                y++;
            }
        }
        
        int[] res = new int[matrix.length * matrix[0].length];
        int idx = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            if (i % 2 == 0) {
                for (int j = 0; j < list.size(); j++) {
                    res[idx++] = list.get(j);
                }
            } else {
                for (int j = list.size() - 1; j >= 0; j--) {
                    res[idx++] = list.get(j);
                }
            }
        }
        
        return res;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
}