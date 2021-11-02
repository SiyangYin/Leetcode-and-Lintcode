public class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0, j = 0, k = nums.length - 1; j <= k; ) {
            if (nums[j] == 0) {
                swap(nums, i++, j++);
            } else if (nums[j] == 2) {
                swap(nums, j, k--);
            } else {
                j++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        new Solution().sortColors(new int[]{0, 0, 0, 2, 1, 1, 0});
    }
}
