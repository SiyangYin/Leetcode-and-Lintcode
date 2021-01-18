import java.util.Arrays;

public class Solution2 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n * n);
            dp[i][1 << i] = dp[i][0] = 0;
        }
        
        for (int s = 1; s < 1 << n; s++) {
            for (boolean repeat = true; repeat; ) {
                repeat = false;
                for (int cur = 0; cur < n; cur++) {
                    if (((s >> cur) & 1) == 1) {
                        for (int next : graph[cur]) {
                            if (1 + dp[cur][s] < dp[next][s | (1 << next)]) {
                                dp[next][s | (1 << next)] = 1 + dp[cur][s];
                                repeat = true;
                            }
                        }
                    }
                }
                
                // System.out.println(Integer.toBinaryString(s));
                // for (int[] row : dp) {
                //     System.out.println(Arrays.toString(row));
                // }
                // System.out.println("========");
            }
        }
        
        int res = n * n;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i][(1 << n) - 1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] g = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(new Solution2().shortestPathLength(g));
    }
}
