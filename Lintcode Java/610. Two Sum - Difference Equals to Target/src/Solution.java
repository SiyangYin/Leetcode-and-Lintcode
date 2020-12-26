import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > Math.abs(target)) {
                j++;
            }
            
            if (Math.abs(nums[i] - nums[j]) == Math.abs(target) && i > j) {
                return new int[]{nums[j], nums[i]};
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum7(new int[]{2, 7, 15, 24}, 9)));
    }
}
