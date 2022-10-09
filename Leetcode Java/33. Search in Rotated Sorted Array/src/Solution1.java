public class Solution1 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + r >>1;
            if (nums[l] <= target && target <= nums[m]) {
                return bs(nums, l, m, target);
            }
            else if (nums[m] <= target && target <= nums[r]) {
                return bs(nums, m, r, target);
            }
            else if (nums[l] <= target && nums[m] < nums[r] || target < nums[m] && nums[m] < nums[r]) {
                r = m - 1;
            }
            else if (target <= nums[r] && nums[r] < nums[m] || nums[l] <= target && nums[m] < target) {
                l = m + 1;
            }
            else {
                return -1;
            }
        }
        return -1;
    }

    public int bs(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution1().search(new int[]{1}, 0));
    }
}
