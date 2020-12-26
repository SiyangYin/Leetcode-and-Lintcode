import java.util.Arrays;

public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[][] memo = new int[A.length][A.length];
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        return dfs(A, 0, A.length - 1, memo, prefixSum);
    }
    
    private int dfs(int[] A, int i, int j, int[][] memo, int[] prefixSum) {
        if (j - i == 1) {
            memo[i][j] = A[i] + A[j];
            return memo[i][j];
        } else if (i == j){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int total = prefixSum[j + 1] - prefixSum[i];
        for (int k = i; k < j; k++) {
            int part1 = memo[i][k] == 0 ? dfs(A, i, k, memo, prefixSum) : memo[i][k];
            int part2 = memo[k + 1][j] == 0 ? dfs(A, k + 1, j, memo, prefixSum) : memo[k + 1][j];
            min = Math.min(min, part1 + part2);
        }
        memo[i][j] = min + total;
        return memo[i][j];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stoneGame(new int[]{3, 4, 3}));
        System.out.println(new Solution().stoneGame(new int[]{3}));
    }
}
