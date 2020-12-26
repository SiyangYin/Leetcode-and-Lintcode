import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        rows.sort(Integer::compareTo);
        cols.sort(Integer::compareTo);
        
        int x = rows.get(rows.size() / 2), y = cols.get(cols.size() / 2);
        int res = 0;
        for (int i = 0; i < rows.size(); i++) {
            res += Math.abs(rows.get(i) - x);
        }
        for (int i = 0; i < cols.size(); i++) {
            res += Math.abs(cols.get(i) - y);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
        };
        System.out.println(new Solution().minTotalDistance(grid));
    }
}
