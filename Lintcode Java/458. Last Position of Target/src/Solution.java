public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        
        return nums[r] == target ? r : -1;
    }
    
    public static void main(String[] args) {
        System.out.println("new Solution().lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 6) = " + new Solution().lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 6));
    }
}