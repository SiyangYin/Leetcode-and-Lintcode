public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0, r = nums.length - 1;
        int len = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= nums[len - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return nums[l];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
