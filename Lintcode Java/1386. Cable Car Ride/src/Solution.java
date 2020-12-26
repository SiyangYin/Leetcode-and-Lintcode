public class Solution {
    
    private int res;
    
    /**
     * @param height: the Cable car station height
     * @return: the longest time that he can ride
     */
    public int cableCarRide(int[][] height) {
        // Write your code here
        res = 1;
        int[][] path = new int[height.length][height[0].length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[0].length; j++) {
                dfs(i, j, height, path);
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] height, int[][] path) {
        if (path[x][y] != 0) {
            return path[x][y];
        }
        
        path[x][y] = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int nextX = x + i, nextY = y + j;
                if (inBound(nextX, nextY, height) && height[nextX][nextY] > height[x][y]) {
                    path[x][y] = Math.max(path[x][y], 1 + dfs(nextX, nextY, height, path));
                }
            }
        }
        
        res = Math.max(res, path[x][y]);
        return path[x][y];
    }
    
    private boolean inBound(int x, int y, int[][] height) {
        return 0 <= x && x < height.length && 0 <= y && y < height[0].length;
    }
}
