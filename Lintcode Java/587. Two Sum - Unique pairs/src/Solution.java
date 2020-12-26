import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                count++;
                int left = nums[i], right = nums[j];
                while (i < j && nums[i] == left) {
                    i++;
                }
                while (i < j && nums[j] == right) {
                    j--;
                }
            }
        }
        
        return count;
    }
}
