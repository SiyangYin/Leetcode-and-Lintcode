public class Solution2 {
    /**
     * @param S: A string
     * @param T: A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int l1 = S.length(), l2 = T.length();
        int[] dp = new int[l2 + 1];
        
        for (int i = 0; i <= l1; i++) {
            for (int j = l2; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = 1;
                } else if (i == 0) {
                    dp[j] = 0;
                } else {
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        
        return dp[l2];
    }
    
    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        
        System.out.println(new Solution2().numDistinct(S, T));
    }
}
