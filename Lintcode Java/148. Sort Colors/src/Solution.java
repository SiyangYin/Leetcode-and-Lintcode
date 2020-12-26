import java.util.Arrays;

public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int l = -1, r = nums.length, i = 0;
        while (i < r) {
            if (nums[i] == 0) {
                swap(nums, i++, ++l);
            } else if (nums[i] == 2) {
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
    
    public static void main(String[] args) {
        new Solution().sortColors(new int[]{1, 0, 0, 1, 1, 2, 1, 0, 2, 2, 1, 0});
        new Solution().sortColors(new int[]{0, 0, 1, 1, 2, 1, 0, 2, 2, 1, 0});
    }
}
