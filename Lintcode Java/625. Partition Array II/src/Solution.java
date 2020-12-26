public class Solution {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        if (nums == null ||  nums.length == 0) {
            return;
        }
        
        int l = -1, i = 0, r = nums.length;
        while (i < r) {
            if (nums[i] < low) {
                swap(nums, i++, ++l);
            } else if (nums[i] > high) {
                swap(nums, i, --r);
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
