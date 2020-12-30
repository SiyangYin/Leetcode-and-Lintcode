public class Solution2 {
    public int numDistinct(String s, String t) {
        if (s.isEmpty()) {
            return t.isEmpty() ? 1 : 0;
        }
        
        int[][] dp = new int[2][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        
        for (int i = 1; i < s.length(); i++) {
            dp[i & 1][0] = dp[i - 1 & 1][0] + (s.charAt(i) == t.charAt(0) ? 1 : 0);
            for (int j = 1; j < t.length(); j++) {
                dp[i & 1][j] = dp[i - 1 & 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i & 1][j] += dp[i - 1 & 1][j - 1];
                }
            }
        }
        
        return dp[s.length() - 1 & 1][t.length() - 1];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().numDistinct("rabbbit", "rabbit"));
        System.out.println(new Solution2().numDistinct("bagbag", "bag"));
    }
}
