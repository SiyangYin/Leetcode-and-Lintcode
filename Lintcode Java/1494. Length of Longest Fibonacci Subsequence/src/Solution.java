import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A:
     * @return: the length
     */
    public int lengthofLongestFibonacciSubsequence(int[] A) {
        // Write your code here.
        int n = A.length;
        int[][] dp = new int[n][n];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                dp[i][j] = 2;
                int prev = A[j] - A[i];
                
                if (map.containsKey(prev) && map.get(prev) < i) {
                    dp[i][j] = 1 + dp[map.get(prev)][i];
                }
                
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res == 2 ? 0 : res;
    }
}
