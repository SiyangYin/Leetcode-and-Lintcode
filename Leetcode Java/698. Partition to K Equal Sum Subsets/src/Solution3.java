import java.util.Arrays;

public class Solution3 {
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
        
        if (nums[0] > sum / k && nums[nums.length - 1] >= 0) {
            return false;
        }
        
        return dfs(0, sum, new boolean[1 << nums.length], nums, sum / k);
    }
    
    private boolean dfs(int used, int remain, boolean[] set, int[] nums, int target) {
        if (remain == 0) {
            return true;
        }
        
        if (set[used]) {
            return false;
        }
        
        set[used] = true;
        int extra = (remain - 1) % target + 1;
        // int extra = remain % target;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= extra && ((used >> i) & 1) == 0) {
                if (dfs(used | (1 << i), remain - nums[i], set, nums, target)) {
                    return true;
                }
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
        // System.out.println(new Solution3().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        // System.out.println(new Solution3().canPartitionKSubsets(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 5));
        System.out.println(new Solution3().canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
    }
}
