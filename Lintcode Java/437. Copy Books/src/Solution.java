import java.util.Arrays;

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k:     An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        k = Math.min(k, pages.length);
        
        int[][] dp = new int[k + 1][pages.length + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= pages.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int lastTime = 0;
                for (int l = j - 1; l >= 0; l--) {
                    lastTime += pages[l];
                    if (l >= 1) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][l], lastTime));
                        
                        if (lastTime >= dp[i - 1][l]) {
                            break;
                        }
                    } else {
                        dp[i][j] = Math.min(dp[i][j], lastTime);
                    }
                }
            }
        }
        
        return dp[k][pages.length];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().copyBooks(new int[]{3, 2, 4}, 3));
    }
}