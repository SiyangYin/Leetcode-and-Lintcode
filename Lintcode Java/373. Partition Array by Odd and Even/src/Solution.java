import java.util.Arrays;

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = {2147483644,2147483645,2147483646,2147483647};
        new Solution().partitionArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}