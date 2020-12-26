import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public int[] findErrorNums(int[] nums) {
        // Write your code here
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                while (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
     
        return null;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{2, 1, 2, 4})));
    }
}
