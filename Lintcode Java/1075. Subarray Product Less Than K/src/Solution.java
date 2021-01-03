public class Solution {
    /**
     * @param nums: an array
     * @param k:    an integer
     * @return: the number of subarrays where the product of all the elements in the subarray is less than k
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Write your code here
        if (k <= 1) {
            return 0;
        }
        
        int res = 0, prod = 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[j];
                j++;
            }
            
            res += i - j + 1;
        }
        
        return res;
    }
}
