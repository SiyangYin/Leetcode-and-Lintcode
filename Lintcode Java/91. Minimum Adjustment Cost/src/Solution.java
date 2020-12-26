import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            max = Math.max(max, num);
        }
        
        int[][] dp = new int[A.size()][max + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        for (int i = 1; i <= max; i++) {
            dp[0][i] = Math.abs(A.get(0) - i);
        }
        
        for (int i = 1; i < A.size(); i++) {
            for (int j = 1; j <= max; j++) {
                int l = Math.max(j - target, 1), r = Math.min(j + target, max);
                for (int k = l; k <= r; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i) - j));
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= max; i++) {
            res = Math.min(res, dp[A.size() - 1][i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 5, 4, 7);
        System.out.println(new Solution().MinAdjustmentCost(A, 2));
    }
}
