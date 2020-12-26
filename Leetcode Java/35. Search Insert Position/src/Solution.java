public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        if (nums[l] >= target) {
            return l;
        } else {
            return l + 1;
        }
    }
}
