import java.util.Arrays;

public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int[] dp = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            if (i < values.length - 2) {
                dp[i] = Math.max(values[i] + values[i + 1] - dp[i + 2], values[i] - dp[i + 1]);
            } else if (i == values.length - 1){
                dp[i] = values[i];
            } else {
                dp[i] = values[i] + values[i + 1];
            }
        }
        
        System.out.println(Arrays.toString(dp));
        return dp[0] > 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstWillWin(new int[]{1, 2, 4, 8}));
    }
}