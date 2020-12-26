import java.util.Arrays;

public class Solution2 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        reverse(nums);
        
        sum /= k;
        if (nums[nums.length - 1] >= 0 && nums[0] > sum) {
            return false;
        }
        
        int[] group = new int[k];
        int i = 0;
        while (i < nums.length && nums[i] == sum) {
            group[i++] = sum;
        }
        
        return dfs(i, nums, i, group, sum);
    }
    
    private boolean dfs(int pos, int[] nums, int start, int[] group, int target) {
        if (pos == nums.length) {
            return true;
        }
        
        for (int i = start; i < group.length; i++) {
            if (group[i] + nums[pos] <= target) {
                group[i] += nums[pos];
                if (dfs(pos + 1, nums, start, group, target)) {
                    return true;
                }
                
                group[i] -= nums[pos];
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
        System.out.println(new Solution2().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        // System.out.println(new Solution2().canPartitionKSubsets(new int[]{5,5,5,5,5,5,5,5,5,5}, 5));
    }
}
