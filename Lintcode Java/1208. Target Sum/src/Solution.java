public class Solution {
    
    private int res;
    
    /**
     * @param nums: the given array
     * @param s:    the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    public int findTargetSumWays(int[] nums, int s) {
        // Write your code here
        int[] suffSum = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffSum[i] = nums[i];
            if (i + 1 < nums.length) {
                suffSum[i] += suffSum[i + 1];
            }
        }
        
        dfs(0, 0, nums, s, suffSum);
        return res;
    }
    
    private void dfs(int pos, int curSum, int[] nums, int s, int[] suffSum) {
        if (pos == nums.length) {
            if (curSum == s) {
                res++;
            }
            
            return;
        }
        
        if (Math.abs(s - curSum) <= suffSum[pos]) {
            dfs(pos + 1, curSum + nums[pos], nums, s, suffSum);
            dfs(pos + 1, curSum - nums[pos], nums, s, suffSum);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
