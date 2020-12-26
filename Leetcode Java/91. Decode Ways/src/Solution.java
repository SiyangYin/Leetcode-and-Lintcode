public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
       
        int[] dp = new int[s.length()];
        if (check1(s.charAt(0))) {
            dp[0] = 1;
        }
        if (s.length() == 1) {
            return dp[0];
        }
    
        if (check1(s.charAt(1))) {
            dp[1] += dp[0];
        }
        if (check2(s.charAt(0), s.charAt(1))) {
            dp[1]++;
        }
        
        for (int i = 2; i < s.length(); i++) {
            if (check1(s.charAt(i))) {
                dp[i] += dp[i - 1];
            }
            if (check2(s.charAt(i - 1), s.charAt(i))) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length() - 1];
    }
    
    public boolean check1(char a) {
        return a != '0';
    }
    
    public boolean check2(char a, char b) {
        return a == '1' || (a == '2' && b >= '0' && b <= '6');
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("12"));
    }
}
