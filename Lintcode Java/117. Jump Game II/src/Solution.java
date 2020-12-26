import java.util.Arrays;

public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
    
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[A.length - 1];
    }
}
