import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= m * n;
        int x = 0, y = 0;
        label:
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                k--;
                
                if (k == 0) {
                    x = i;
                    y = j;
                    break label;
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = x; i < m; i++) {
            int j = i == x ? y : 0;
            for (; j < n; j++) {
                add(res, n, grid[i][j]);
            }
        }
        for (int i = 0; i <= x; i++) {
            int bound = i == x ? y : n;
            for (int j = 0; j < bound; j++) {
                add(res, n, grid[i][j]);
            }
        }
        
        return res;
    }
    
    private void add(List<List<Integer>> list, int n, int x) {
        if (list.isEmpty() || list.get(list.size() - 1).size() == n) {
            list.add(new ArrayList<>());
        }
        
        list.get(list.size() - 1).add(x);
    }
}
