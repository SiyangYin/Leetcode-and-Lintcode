public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
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
                return m;
            }
        }
        
        return nums[l] == target ? l : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPosition(new int[]{4, 4}, 3));
    }
}
