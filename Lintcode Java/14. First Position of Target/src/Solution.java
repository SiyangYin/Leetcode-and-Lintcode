public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                r = m;
            }
        }
        
        return nums[l] == target ? l : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().binarySearch(new int[]{1, 2, 2, 4, 5, 5}, 0));
    }
}