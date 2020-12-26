import java.util.Arrays;

public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return a boolean, denote whether the array can be divided into k non-empty subsets whose sums are all equal
     */
    public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        sum /= k;
        Arrays.sort(nums);
        reverse(nums);
        
        return dfs(nums, 0, sum, new boolean[nums.length], 0, k);
    }
    
    private boolean dfs(int[] nums, int curSum, int sum, boolean[] used, int count, int k) {
        if (count == k) {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    return false;
                }
            }
            
            return true;
        }
        
        if (curSum == sum && dfs(nums, 0, sum, used, count + 1, k)) {
            return true;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            if (curSum + nums[i] <= sum) {
                used[i] = true;
                if (dfs(nums, curSum + nums[i], sum, used, count, k)) {
                    return true;
                }
                used[i] = false;
            }
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
