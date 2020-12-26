public class Solution2 {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len + 1];
        // dp[i][i][l]    s1[0,...,i] s2[0,...,i]
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int l = 1; l <= Math.min(i, j) + 1; l++) {
                    String sub1 = s1.substring(i - l + 1, i + 1), sub2 = s2.substring(j - l + 1, j + 1);
                    dp[i][j][l] = sub1.equals(sub2);
                    if (dp[i][j][l]) {
                        continue;
                    }
                    
                    if (l == 1) {
                        dp[i][j][l] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    
                    for (int k = 1; k < l; k++) {
                        dp[i][j][l] |= dp[i][j][k] && dp[i - k][j - k][l - k];
                        dp[i][j][l] |= dp[i][j - (l - k)][k] && dp[i - k][j][l - k];
                        if (dp[i][j][l]) {
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[len - 1][len - 1][len];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().isScramble("abb", "bba"));
        System.out.println(new Solution2().isScramble("great", "rgeaa"));
        System.out.println(new Solution2().isScramble("great", "rgeat"));
        System.out.println(new Solution2().isScramble("gre", "rge"));
        System.out.println(new Solution2().isScramble("gr", "rg"));
        System.out.println(new Solution2().isScramble("gr", "gr"));
    
        System.out.println(new char[]{'a', 'b', 'c'});
    }
}
