public class Solution {
    public int minDifficulty(int[] A, int d) {
        int n = A.length;
        if (n < d) {
            return -1;
        }
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        int[][] dp = new int[n][d + 1];
        return dfs(0, d, A, dp, preSum);
    }
    
    private int dfs(int idx, int count, int[] A, int[][] dp, int[] preSum) {
        if (dp[idx][count] > 0) {
            return dp[idx][count];
        }
        
        if (idx == A.length - count) {
            dp[idx][count] = preSum[A.length] - preSum[idx];
            return dp[idx][count];
        }
        
        int curMax = 0;
        if (count == 1) {
            for (int i = idx; i < A.length; i++) {
                curMax = Math.max(curMax, A[i]);
            }
            
            dp[idx][count] = curMax;
            return curMax;
        }
        
        int res = preSum[A.length] - preSum[idx];
        for (int i = idx; i <= A.length - count; i++) {
            curMax = Math.max(curMax, A[i]);
            res = Math.min(res, curMax + dfs(i + 1, count - 1, A, dp, preSum));
        }
        
        dp[idx][count] = res;
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {6, 5, 4, 3, 2, 1};
        System.out.println(new Solution().minDifficulty(A, 2));
    }
}
