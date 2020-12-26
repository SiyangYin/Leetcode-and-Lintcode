public class Solution {
    /**
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
    
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
    
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
    
        int j = binarySearch(nums, i, nums.length - 1, nums[i - 1]);
        swap(nums, i - 1, j);
        reverse(nums, i, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (nums[m] > target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return r;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
