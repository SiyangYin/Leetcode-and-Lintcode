public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else {
                    int minBlood = Integer.MAX_VALUE;
                    if (i < m - 1) {
                        minBlood = Math.min(minBlood, dp[i + 1][j]);
                    }
                    if (j < n - 1) {
                        minBlood = Math.min(minBlood, dp[i][j + 1]);
                    }
                    
                    dp[i][j] = Math.max(1, minBlood - dungeon[i][j]);
                }
            }
        }
        
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] du = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        System.out.println(new Solution().calculateMinimumHP(du));
    }
}
