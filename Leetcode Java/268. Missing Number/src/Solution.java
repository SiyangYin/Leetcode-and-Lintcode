public class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{3, 0, 1}));
    }
    
}
