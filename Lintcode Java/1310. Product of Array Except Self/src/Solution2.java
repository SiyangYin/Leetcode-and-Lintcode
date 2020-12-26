public class Solution2 {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        int[] left = new int[nums.length], right = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            left[i] = i == 0 ? nums[0] : nums[i] * left[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = i == nums.length - 1 ? nums[nums.length - 1] : nums[i] * right[i + 1];
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            if (i >= 1) {
                prod *= left[i - 1];
            }
            if (i <= nums.length - 2) {
                prod *= right[i + 1];
            }
            res[i] = prod;
        }
        
        return res;
    }
}
