public class Solution {
    public boolean stoneGame(int[] piles) {
        return dfs(piles, 0, piles.length - 1, new int[piles.length][piles.length]) > 0;
    }
    
    private int dfs(int[] piles, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
    
        if (i == j) {
            memo[i][i] = piles[i];
            return piles[i];
        }
        
        int score1 = memo[i + 1][j] != 0 ? piles[i] - memo[i + 1][j] : piles[i] - dfs(piles, i + 1, j, memo);
        int score2 = memo[i][j - 1] != 0 ? piles[j] - memo[i][j - 1] : piles[j] - dfs(piles, i, j - 1, memo);
        memo[i][j] = Math.max(score1, score2);
        return memo[i][j];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stoneGame(new int[]{1, 5, 1}));
    }
}
