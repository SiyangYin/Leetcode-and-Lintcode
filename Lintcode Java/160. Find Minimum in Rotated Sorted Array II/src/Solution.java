public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // squeeze the interval while maintaining the minimum is still within
                // the interval
                while (nums[mid] == nums[right] && right > mid) {
                    right--;
                }
            }
        }
        return Math.min(nums[left], nums[right]);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{3, 1, 1, 1, 3}));
    }
}