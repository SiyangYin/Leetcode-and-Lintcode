import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, sb, visited, dirs);
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int x, int y, int[][] grid, StringBuilder sb, boolean[][] visited, int[][] dirs) {
        visited[x][y] = true;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (inBound(nextX, nextY, grid) && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                sb.append(i);
                dfs(nextX, nextY, grid, sb, visited, dirs);
                sb.append('#');
            }
        }
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1}};
        System.out.println(new Solution().numberofDistinctIslands(grid));
    }
}
