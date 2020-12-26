import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                dp[i][j] = 2;
                int prev = A[j] - A[i];
                
                if (prev < A[i] && map.containsKey(prev)) {
                    dp[i][j] = 1 + dp[map.get(prev)][i];
                }
                
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res > 2 ? res : 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
