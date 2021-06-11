public class Solution {
    /**
     * @param grids: a integer two-dimensional array
     * @return: return the maximum sum of golds
     */
    public int FindMaximumGold(int[][] grids) {
        // write your code here
        int m = grids.length, n = grids[0].length, max = 0;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grids[i][j] != 0) {
                    max = Math.max(max, dfs(i, j, grids, d));
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int x, int y, int[][] grids, int[] d) {
        int res = grids[x][y], a = res, max = 0;
        grids[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int X = x + d[i], Y = y + d[i + 1];
            if (0 <= X && X < grids.length && 0 <= Y && Y < grids[0].length && grids[X][Y] != 0) {
                max = Math.max(max, dfs(X, Y, grids, d));
            }
        }
        
        grids[x][y] = a;
        return res + max;
    }
    
    public static void main(String[] args) {
        int[][] g = {
                {2, 0, 1, 3},
                {1, 0, 3, 1},
                {1, 0, 3, 1}};
        System.out.println(new Solution().FindMaximumGold(g));
    }
}
