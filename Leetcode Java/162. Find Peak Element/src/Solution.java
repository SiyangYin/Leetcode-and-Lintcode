public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            // At least one of the below two cases must be true
            if (mid - 1 >= 0) {
                if (nums[mid] < nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            
            else if (mid + 1 <= nums.length - 1) {
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] > nums[right]) {
            return left;
        } else {
            return right;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2};
        
        System.out.println(new Solution().findPeakElement(nums));
    }
}
