import java.util.Arrays;

public class Solution {
    /**
     * @param maxChoosableInteger: a Integer
     * @param desiredTotal: a Integer
     * @return: if the first player to move can force a win
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // Write your code here
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        int[] dp = new int[1 << maxChoosableInteger];
        Arrays.fill(dp, -1);
        return dfs(dp, 0, 0, maxChoosableInteger, desiredTotal);
    }
    
    private boolean dfs(int[] dp, int state, int curSum, int maxInt, int desiredTotal) {
        if (dp[state] != -1) {
            return dp[state] == 1;
        }
        
        if (curSum >= desiredTotal) {
            dp[state] = 0;
            return false;
        }
        
        for (int i = 1; i <= maxInt; i++) {
            if (((state >> i - 1) & 1) != 0) {
                continue;
            }
            
            if (!dfs(dp, state | (1 << i - 1), curSum + i, maxInt, desiredTotal)) {
                return true;
            }
        }
        
        dp[state] = 0;
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(10, 11));
        System.out.println(new Solution().canIWin(10, 10));
    }
}
