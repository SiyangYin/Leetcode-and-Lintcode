public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int res = 0;
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i >= 1 && j >= 1) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubstring("ABCD", "CBCE"));
        System.out.println(new Solution().longestCommonSubstring("ABCD", "EACB"));
    }
}