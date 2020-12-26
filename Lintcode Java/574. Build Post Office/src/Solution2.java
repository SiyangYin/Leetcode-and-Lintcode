import java.util.Arrays;

public class Solution2 {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        int[] cntRow = new int[m], cntCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cntRow[i]++;
                    cntCol[j]++;
                }
            }
        }
    
        int res = Integer.MAX_VALUE;
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int dis = 0;
                    for (int k = 0; k < m; k++) {
                        dis += cntRow[k] * Math.abs(k - i);
                        if (dis >= res) {
                            break;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        dis += cntCol[k] * Math.abs(k - j);
                        if (dis >= res) {
                            break;
                        }
                    }
                    
                    res = Math.min(res, dis);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(new Solution2().shortestDistance(g));
    }
}
