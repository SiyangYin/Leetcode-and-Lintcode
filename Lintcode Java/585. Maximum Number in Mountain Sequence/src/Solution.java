public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] > nums[n - 2]) {
            return nums[n - 1];
        }
        
        int l = 1, r = n - 2;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] >= nums[m - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return nums[l];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mountainSequence(new int[]{1, 2, 4, 8, 6, 3}));
    }
}