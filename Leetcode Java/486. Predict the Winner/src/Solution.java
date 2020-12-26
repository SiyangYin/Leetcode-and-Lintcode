import java.util.Arrays;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1 || (nums.length & 1) == 0) {
            return true;
        }
        
        int[][] f = new int[nums.length][nums.length];
        dfs(nums, 0, nums.length - 1, f);
        System.out.println(Arrays.deepToString(f));
        return dfs(nums, 0, nums.length - 1, f) >= 0;
    }
    
    private int dfs(int[] nums, int i, int j, int[][] f) {
        if (j == i) {
            f[i][i] = nums[i];
            return f[i][i];
        }
        // if (j - i == 1) {
        //     f[i][j] = Math.abs(nums[i] - nums[j]);
        //     return f[i][j];
        // }
        
        int score1 = f[i + 1][j] != 0 ? f[i + 1][j] : dfs(nums, i + 1, j, f);
        int score2 = f[i][j - 1] != 0 ? f[i][j - 1] : dfs(nums, i, j - 1, f);
        
        f[i][j] = Math.max(nums[i] - score1, nums[j] - score2);
        return f[i][j];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new Solution().PredictTheWinner(new int[]{0, 0, 7, 6, 5, 6, 1}));
    }
}
