public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] >= nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            }
        }
        
        return nums[l];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
    }
}