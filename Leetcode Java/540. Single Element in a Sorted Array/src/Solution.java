public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] == nums[m + 1]) {
                int larger = r - m - 1;
                if (larger % 2 == 0) {
                    r = m - 1;
                } else {
                    l = m + 2;
                }
            } else {
                int larger = r - m;
                if (larger % 2 == 0) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        
        return nums[l];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        // System.out.println(new Solution().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{3, 7, 7}));
    }
}
