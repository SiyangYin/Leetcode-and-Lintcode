public class Solution {
    /**
     * @param S: The string s
     * @return: The number of distinct, non-empty subsequences of S.
     */
    public int distinctSubseqII(String S) {
        // Write your code here
        int res = 0, MOD = (int) (1E9 + 7);
        int[] dp = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (S.charAt(j) != S.charAt(i)) {
                    dp[i] += dp[j];
                    dp[i] %= MOD;
                }
            }
        }
        
        for (int i : dp) {
            res += i;
            res %= MOD;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().distinctSubseqII("abc"));
        System.out.println(new Solution().distinctSubseqII("aba"));
        System.out.println(new Solution().distinctSubseqII("aaa"));
        System.out.println(new Solution().distinctSubseqII("abab"));
    }
}
