public class Solution2 {
    public void moveZeroes(int[] nums) {
        int i = -1, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[++i] = nums[j++];
            } else {
                j++;
            }
        }
        while (i < nums.length - 1) {
            nums[++i] = 0;
        }
    }
    
}
