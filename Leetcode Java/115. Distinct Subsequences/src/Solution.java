import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, 0, s, t, dp);
    }
    
    private int dfs(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        
        if (i == s.length()) {
            return 0;
        }
        
        if (s.length() - i < t.length() - j) {
            dp[i][j] = 0;
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int res = 0;
        for (int k = i; k < s.length(); k++) {
            res = dfs(i + 1, j, s, t, dp);
            if (s.charAt(i) == t.charAt(j)) {
                res += dfs(i + 1, j + 1, s, t, dp);
            }
        }
        
        dp[i][j] = res;
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
        System.out.println(new Solution().numDistinct("bagbag", "bag"));
        // System.out.println(new Solution().numDistinct("bag", "bag"));
    }
}
