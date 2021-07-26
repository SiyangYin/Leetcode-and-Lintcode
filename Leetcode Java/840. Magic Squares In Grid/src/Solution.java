import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i + 2 < grid.length; i++) {
            for (int j = 0; j + 2 < grid[0].length; j++) {
                if (check(grid, i, j)) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private boolean check(int[][] g, int x, int y) {
        if (!(checkRow(g, x, y) && checkRow(g, x + 1, y) && checkRow(g, x + 2, y)
                && checkCol(g, x, y) && checkCol(g, x, y + 1) && checkCol(g, x, y + 2)
                && g[x][y] + g[x + 1][y + 1] + g[x + 2][y + 2] == 15 && g[x + 2][y] + g[x + 1][y + 1] + g[x][y + 2] == 15)) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (!set.add(g[i][j]) || !(1 <= g[i][j] && g[i][j] <= 9)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkCol(int[][] g, int x, int y) {
        int sum = 0;
        for (int i = x; i < x + 3; i++) {
            sum += g[i][y];
        }
        return sum == 15;
    }
    
    private boolean checkRow(int[][] g, int x, int y) {
        int sum = 0;
        for (int i = y; i < y + 3; i++) {
            sum += g[x][i];
        }
        return sum == 15;
    }
}
