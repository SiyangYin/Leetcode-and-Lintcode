public class Solution2 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[] neighbors = new int[5];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        count++;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        count++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        count++;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        count++;
                    }
                    neighbors[count]++;
                }
            }
        }
    
        int res = 0;
        for (int i = 0; i <= 4; i++) {
            res += neighbors[i] * (4 - i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid = {{1, 1}, {1, 1}};
        System.out.println(new Solution2().islandPerimeter(grid));
    }
}
