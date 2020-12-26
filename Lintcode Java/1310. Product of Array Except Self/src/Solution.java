import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        int prod = 1, zeroCount = 0, zeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                prod *= nums[i];
            } else {
                zeroCount++;
                zeroIdx = i;
            }
        }
        
        if (zeroCount >= 1) {
            Arrays.fill(nums, 0);
            if (zeroCount == 1) {
                nums[zeroIdx] = prod;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = prod / nums[i];
            }
        }
        
        return nums;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
