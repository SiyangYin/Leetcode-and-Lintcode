public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
    
        for (int i = 0; i < nums.length; i++) {
            while (1 <= nums[i] && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
