import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        List<Integer> row = new ArrayList<>(), col = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        Collections.sort(row);
        Collections.sort(col);
        int x = row.get(row.size() / 2), y = col.get(col.size() / 2);
        
        int res = 0;
        for (int r : row) {
            res += Math.abs(r - x);
        }
        for (int c : col) {
            res += Math.abs(c - y);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};
        System.out.println(new Solution().minTotalDistance(grid));
    }
}
