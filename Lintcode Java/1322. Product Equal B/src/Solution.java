import java.util.*;

public class Solution {
    /**
     * @param B: the all Ai product equal to B
     * @param A: the positive int array
     * @return: return the minium cost
     */
    public int getMinCost(int B, int[] A) {
        // write your code here
        List<Integer> fac = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= B; i++) {
            if (B % i == 0) {
                fac.add(i);
                map.put(i, fac.size() - 1);
            }
        }
    
        int n = fac.size();
        // dp[k][i]是调整A[0 : k]使得整个乘积是fac[i]的最小代价
        int[][] dp = new int[2][n];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = Math.abs(A[0] - fac.get(i));
        }
    
        for (int i = 1; i < A.length; i++) {
            Arrays.fill(dp[i & 1], Integer.MAX_VALUE);
            // 枚举乘积是fac[j]
            for (int j = 0; j < n; j++) {
                // 枚举最后一个数是fac[k]
                for (int k = 0; k <= j; k++) {
                    if (fac.get(j) % fac.get(k) == 0) {
                        dp[i & 1][j] = Math.min(dp[i & 1][j], dp[i - 1 & 1][map.get(fac.get(j) / fac.get(k))] + Math.abs(A[i] - fac.get(k)));
                    }
                }
            }
        }
        
        return dp[A.length - 1 & 1][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getMinCost(12, new int[]{1, 3, 5}));
    }
}
