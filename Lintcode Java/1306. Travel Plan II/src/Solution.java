import java.util.Arrays;

public class Solution {
    /**
     * @param arr: the distance between any two cities
     * @return: the minimum distance Alice needs to walk to complete the travel plan
     */
    public int travelPlanII(int[][] arr) {
        // Write your code here.
        int n = arr.length;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, 1, dp, arr);
    }
    
    private int dfs(int cur, int state, int[][] dp, int[][] arr) {
        if (dp[cur][state] != -1) {
            return dp[cur][state];
        }
        
        if (state == (1 << arr.length) - 1) {
            dp[cur][state] = arr[cur][0];
            return dp[cur][state];
        }
        
        int res = 1 << 30;
        for (int i = 1; i < arr.length; i++) {
            if ((state >> i & 1) == 0) {
                res = Math.min(res, arr[cur][i] + dfs(i, state | (1 << i), dp, arr));
            }
        }
        
        dp[cur][state] = res;
        return res;
    }
    
    public static void main(String[] args) {
        int[][] a = {
                {0, 1, 2},
                {1, 0, 2},
                {2, 1, 0}};
        System.out.println(new Solution().travelPlanII(a));
    }
}
