import java.util.Arrays;

public class Solution {
    /**
     * @param arr: the distance between any two cities
     * @return: the minimum distance Alice needs to walk to complete the travel plan
     */
    public int travelPlan(int[][] arr) {
        // Write your code here.
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int n = arr.length;
        // dp[s][v]表示已经访问过的城市集合是s，当前在v，并且从v出发访问剩余所有城市回到0的最少花费
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE - 10000);
        }
        
        dp[(1 << n) - 1][0] = 0;
    
        for (int s = (1 << n) - 2; s >= 0; s--) {
            for (int v = 0; v < n; v++) {
                for (int u = 0; u < n; u++) {
                    if (((s >> u) & 1) == 0) {
                        dp[s][v] = Math.min(dp[s][v], dp[s | (1 << u)][u] + arr[v][u]);
                    }
                }
            }
        }
    
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2},
                {1, 0, 2},
                {2, 1, 0}};
        System.out.println(new Solution().travelPlan(arr));
    }
}
