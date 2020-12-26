public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }
        
        int l = i, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (nums[m] > nums[i - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        swap(nums, i - 1, l);
        reverse(nums, i, nums.length - 1);
        
        return nums;
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
