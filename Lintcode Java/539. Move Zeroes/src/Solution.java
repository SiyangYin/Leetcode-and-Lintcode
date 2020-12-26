import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
//        System.out.println(Arrays.toString(nums));
    }
    
    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0, 1, 0, 3, 1, 2});
    }
}