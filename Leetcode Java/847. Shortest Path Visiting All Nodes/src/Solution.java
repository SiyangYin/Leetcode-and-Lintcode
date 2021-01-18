import java.util.Arrays;

public class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, n * n);
            row[(1 << n) - 1] = 0;
        }
        
        for (int s = (1 << n) - 2; s > 0; s--) {
            for (boolean repeat = true; repeat; ) {
                repeat = false;
                for (int cur = 0; cur < n; cur++) {
                    if (((s >> cur) & 1) == 1) {
                        for (int next : graph[cur]) {
                            int ne = s | (1 << next);
                            if (1 + dp[next][ne] < dp[cur][s]) {
                                dp[cur][s] = 1 + dp[next][ne];
                                if (s != ne) {
                                    repeat = true;
                                }
                            }
                        }
                    }
                }
            }
            
            // System.out.println("Integer.toBinaryString(s) = " + Integer.toBinaryString(s));
            // for (int i = 0; i < n; i++) {
            //     System.out.println(i + " " + dp[i][s]);
            // }
            // for (int[] row : dp) {
            //     System.out.println(Arrays.toString(row));
            // }
            // System.out.println("============");
        }
        
        int res = n * n;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i][1 << i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1}, {0, 2, 6}, {1, 5, 6}, {6}, {6}, {2}, {4, 3, 1, 2}};
        System.out.println(new Solution().shortestPathLength(g));
    }
}
