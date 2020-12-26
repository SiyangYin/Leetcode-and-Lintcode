public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int endValue = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                while (nums[mid] == nums[right] && right > mid) {
                    right--;
                }
            }
        }
        return (nums[left] < nums[right]) ? nums[left] : nums[right];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{1, 1, -1, 1}));
    }
}
