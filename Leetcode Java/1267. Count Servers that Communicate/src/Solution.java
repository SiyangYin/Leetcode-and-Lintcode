public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m], col = new int[n];
    
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    row[i]++;
                    col[j]++;
                }
            }
        }
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && row[i] == 1 && col[j]==1) {
                    res--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 0}, {1, 1}};
        System.out.println(new Solution().countServers(g));
    }
}
