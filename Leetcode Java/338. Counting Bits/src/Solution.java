import java.util.Arrays;

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = (i & 1) + dp[i >> 1];
        }
        
        return dp;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}