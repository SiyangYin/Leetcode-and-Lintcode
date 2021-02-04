public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int singleNonDuplicate(int[] nums) {
        // write your code here
        int l = 0, r = (nums.length - 2) / 2;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m * 2] != nums[m * 2 + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return nums[l * 2] != nums[l * 2 + 1] ? nums[2 * l] : nums[nums.length - 1];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        // nums = new int[]{1, 1, 2};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}