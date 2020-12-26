public class Solution {
    
    private int res = 0;
    
    /**
     * @param grid: a 2D array
     * @return: the perimeter of the island
     */
    public int islandPerimeter(int[][] grid) {
        // Write your code here
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    return res;
                }
            }
        }
        
        return 0;
    }
    
    private void dfs(int x, int y, int[][] grid) {
        grid[x][y] = 2;
        int[] d = {1, 0, -1, 0, 1};
        int countOf1 = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, grid) && (grid[nextX][nextY] == 1 || grid[nextX][nextY] == 2)) {
                countOf1++;
                if (grid[nextX][nextY] == 1) {
                    dfs(nextX, nextY, grid);
                }
            }
        }
        
        res += 4 - countOf1;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(new Solution().islandPerimeter(grid));
    }
}
