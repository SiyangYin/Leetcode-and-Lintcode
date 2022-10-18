public class Solution1 {
    public boolean search(int[] nums, int target) {
        return dfs(nums, target, 0, nums.length - 1);
    }

    public boolean dfs(int[] nums, int target, int l, int r) {
        if (l < r) {
            int m = l + r >> 1;
            if (nums[m] <= nums[r] && target > nums[m] && target <= nums[r] && bs(nums, target, m + 1, r)) return true;
            if (nums[m] <= nums[r] && (target <= nums[m] || target > nums[r]) && dfs(nums, target, l, m)) return true;
            if (nums[l] <= nums[m] && target >= nums[l] && target <= nums[m] && bs(nums, target, l, m)) return true;
            if (nums[l] <= nums[m] && (target > nums[m] || target <= nums[r]) && dfs(nums, target, m + 1, r)) return true;
        }
        return nums[l] == target;
    }

    public boolean bs(int[] nums, int target, int l, int r) {
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return nums[l] == target;
    }
}
