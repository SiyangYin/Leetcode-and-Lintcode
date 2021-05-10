public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i; j >= 0 && i - j < k; j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], (j >= 1 ? dp[j - 1] : 0) + max * (i - j + 1));
            }
        }
        
        return dp[arr.length - 1];
    }
    
    public static void main(String[] args) {
        int[] A = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        System.out.println(new Solution().maxSumAfterPartitioning(A, 4));
    }
}
