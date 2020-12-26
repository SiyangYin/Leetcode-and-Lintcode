import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == 0)
                continue;
            nums[i++] = nums[j];
        }
        while (i < nums.length) {
            nums[i] = 0;
            ++i;
        }
    }
}