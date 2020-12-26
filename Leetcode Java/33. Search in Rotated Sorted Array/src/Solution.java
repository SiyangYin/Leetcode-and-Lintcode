public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (nums[m] >= nums[0]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        if (target >= nums[0]) {
            r = l;
            l = 0;
        } else {
            l = l + 1;
            r = nums.length - 1;
        }
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] >= target) {
                r = m;
            } else if (nums[m] < target) {
                l = m + 1;
            }
        }
     
        return nums[l] == target ? l : -1;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{1}, 0));
    }
}
