public class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        
        if (text1.length() > text2.length()) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }
        
        int[][] dp = new int[2][text1.length() + 1];
        int index = 0;
        for (int j = 1; j <= text2.length(); j++) {
            for (int i = 1; i <= text1.length(); i++) {
                dp[index][i] = Math.max(dp[index][i - 1], dp[index ^ 1][i]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[index][i] = Math.max(dp[index][i], dp[index ^ 1][i - 1] + 1);
                }
            }
            index ^= 1;
        }
        
        return dp[index ^ 1][text1.length()];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().longestCommonSubsequence("ezupkr", "ubmrapg"));
        // System.out.println(new Solution2().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        System.out.println(new Solution2().longestCommonSubsequence("abcde", "ace"));
    }

}
