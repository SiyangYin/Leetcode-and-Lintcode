public class Solution {
    public int numDecodings(String s) {
        int MOD = (int) (1E9 + 7);
        int[] dp = new int[Math.max(2, s.length() + 1)];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 1; j <= 26; j++) {
                char ch0 = s.charAt(i - 1);
                if (j <= 9) {
                    if (ch0 == '*' || ch0 == '0' + j) {
                        dp[i] += dp[i - 1];
                    }
                } else {
                    char ch1 = s.charAt(i - 2);
                    int i0 = j % 10, i1 = j / 10;
                    if ((ch1 == '*' || ch1 == i1 + '0') && ((ch0 == '*' && i0 != 0) || ch0 == i0 + '0')) {
                        dp[i] += dp[i - 2];
                    }
                }
                
                dp[i] %= MOD;
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("1*"));
    }
}
