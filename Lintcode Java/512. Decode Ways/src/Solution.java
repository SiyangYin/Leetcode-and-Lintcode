import java.util.Arrays;

public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            if (i >= 2) {
                int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("1099"));
    }
}
