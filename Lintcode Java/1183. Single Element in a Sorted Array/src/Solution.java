public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    public int singleNonDuplicate(int[] nums) {
        // write your code here
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (mid + 1 <= nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        nums = new int[]{1, 1, 2};
//        nums = new int[]{3, 3, 7, 7, 10, 11, 11};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}