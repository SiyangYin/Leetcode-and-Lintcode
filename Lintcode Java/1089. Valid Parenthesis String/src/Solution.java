public class Solution {
    /**
     * @param s: the given string
     * @return: whether this string is valid
     */
    public boolean checkValidString(String s) {
        // Write your code here
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int l = i, r = i + len - 1;
                char left = s.charAt(l), right = s.charAt(r);
                if (len == 1) {
                    dp[l][r] = left == '*';
                } else if (len == 2) {
                    dp[l][r] = check(left, right);
                } else {
                    dp[l][r] |= check(left, right) && dp[l + 1][r - 1];
                    for (int j = 1; j < len; j++) {
                        dp[l][r] |= dp[l][l + j - 1] && dp[l + j][r];
                        if (dp[l][r]) {
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
    
    private boolean check(char left, char right) {
        return left != ')' && right != '(';
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("()(*))"));
    }
}
