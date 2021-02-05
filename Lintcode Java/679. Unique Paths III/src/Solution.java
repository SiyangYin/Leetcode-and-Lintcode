import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
     * @param : an array of arrays
     * @return: the sum of all unique weighted paths
     */
    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        if (grid.length ==0|| grid[0].length==0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        Set<Integer>[][] dp = (Set<Integer>[][]) new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
                if (i == 0 && j == 0) {
                    dp[i][j].add(grid[i][j]);
                } else {
                    if (i > 1) {
                        for (int v : dp[i - 1][j]) {
                            dp[i][j].add(v + grid[i][j]);
                        }
                    }
                    if (j > 1) {
                        for (int v : dp[i][j - 1]) {
                            dp[i][j].add(v + grid[i][j]);
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for (int v : dp[m - 1][n - 1]) {
            res += v;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 2}, {3, 4}};
        System.out.println(new Solution().uniqueWeightedPaths(g));
    }
}
