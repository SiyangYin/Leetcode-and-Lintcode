import java.util.Arrays;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
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
        
        if (nums[nums.length - 1] >= 0 && nums[0] > sum) {
            return false;
        }
        
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
    
    public static void main(String[] args) {
        // int[] nums = {4, 3, 2, 3, 5, 2, 1};
        // int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        // int[] nums = {10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6};
        int[] nums = {553, 450, 2412, 1735, 521, 170, 943, 87, 3200, 473, 75, 3819, 492, 324, 689, 629};
        System.out.println(new Solution().canPartitionKSubsets(nums, 4));
    }
}
