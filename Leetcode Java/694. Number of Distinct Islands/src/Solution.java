import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        Set<String> set = new HashSet<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, sb, dirs);
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int x, int y, int[][] grid, StringBuilder sb, int[][] dirs) {
        grid[x][y] = 0;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == 1) {
                sb.append(i);
                dfs(nextX, nextY, grid, sb, dirs);
            }
        }
        sb.append('#');
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}};
        
        
        // int[][] grid = {
        //         {1, 1, 0, 0},
        //         {1, 0, 1, 1},
        //         {0, 0, 0, 1}};
        System.out.println(new Solution().numDistinctIslands(grid));
    }
}
